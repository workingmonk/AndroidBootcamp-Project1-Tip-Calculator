package com.yahoo.workmonk.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class TipCalculator extends Activity {
    public static final String DECIMAL_FORMAT = "#.##";
    public static final String PLUS = " + ";
    public static final String EQUALS = " = ";
    private EditText etBillAmount;
    private TextView tvTipValue;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        etBillAmount = (EditText) findViewById(R.id.etBillAmount);
        tvTipValue = (TextView) findViewById(R.id.tvTipValue);
    }

    public void onCalculateTip10(View v){
        setTipAmount(10);
    }

    public void onCalculateTip15(View v){
        setTipAmount(15);
    }

    public void onCalculateTip20(View v){
        setTipAmount(20);
    }

    public void onCalculateTip25(View v){
        setTipAmount(25);
    }

    public void onCalculateTip5(View v){
        setTipAmount(5);
    }

    private void setTipAmount(double tipPercent){
        double totalBill;
        try {
            totalBill = Double.parseDouble(etBillAmount.getText().toString());
        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), getResources().getText(R.string.numberOnlyError), Toast.LENGTH_SHORT).show();
            return;
        }
        double tipAmount = (tipPercent * totalBill)/100;

        DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);
        tvTipValue.setText(df.format(totalBill) + PLUS +df.format(tipAmount) + EQUALS + df.format(totalBill + tipAmount));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
