package com.example.costaload;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
    EditText mile, diesel;
    Button button1, button2;
    TextView tv, tv2, tv3;
    private double x, y, z, costper, gallon, litres, ophours, stopdrive;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    NumberFormat format = NumberFormat.getCurrencyInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mile = (EditText) findViewById(R.id.mile);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(button1onClickListener);
        button2.setOnClickListener(button2OnClickListener);
        tv = (TextView) findViewById(R.id.cost);
        tv2 = (TextView) findViewById(R.id.cpm);
        tv3 = (TextView) findViewById(R.id.gallons);
        diesel = (EditText) findViewById(R.id.diesel);
    }

    private OnClickListener button1onClickListener = new OnClickListener() {
        public void onClick(final View v) {

            x = Double.parseDouble(mile.getText().toString());
            y = Double.parseDouble(diesel.getText().toString());
            if (checkBox2.isChecked()) {
                x = x * 2;
            }

            if (checkBox1.isChecked()) {
                x = x * 0.62137;
            }

            ophours = 0;
            ophours = (x / 55) + 2;

            if (ophours >= 11) {
                stopdrive = (ophours / 10) - 1;
            }
            if (stopdrive > 1) {
                ophours = ophours + (stopdrive * 10);
            }

            gallon = x / 5.5;

            if (checkBox4.isChecked()) {
                gallon = gallon + (ophours * 1.1);
            }

            if (checkBox3.isChecked()) {
                litres = gallon * 3.785;
                tv3.setText(new DecimalFormat("####.##").format(litres) + "L");
            }

            z = (gallon * y) + (x * 0.655);
            costper = z / x;
            tv.setText(format.format(z));
            tv2.setText(format.format(costper) + "/mile");
            tv3.setText(new DecimalFormat("####.##").format(gallon) + "gal.");
        }

    };

    private OnClickListener button2OnClickListener = new OnClickListener() {
        public void onClick(final View v) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.ratenroll.com"));
            startActivity(browserIntent);
        }
    };
};