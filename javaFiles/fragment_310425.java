package com.dexter.seemab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Calculator extends Activity {
    String display = "";
    Character op = 'q';
    int i, num, numtemp;
    int check = 0;
    EditText rd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        rd = (EditText) findViewById(R.id.etResult);

    }

    public void btnClicked(View v) {
        switch (v.getId()) {
        case R.id.one:
            insert(1);
            break;
        case R.id.two:
            insert(2);
            break;
        case R.id.three:
            insert(3);
            break;
        case R.id.four:
            insert(4);
            break;
        case R.id.five:
            insert(5);
            break;
        case R.id.six:
            insert(6);
            break;
        case R.id.seven:
            insert(7);
            break;
        case R.id.eight:
            insert(8);
            break;
        case R.id.nine:
            insert(9);
            break;
        case R.id.zero:
            insert(0);
            break;
        case R.id.add:
            op = '+';
            perform();
            break;
        case R.id.sub:
            op = '-';
            perform();
            break;
        case R.id.product:
            op = '*';
            perform();
            break;
        case R.id.difference:
            op = '/';
            perform();
            break;
        case R.id.equals:
            calculate();
            break;
        case R.id.clear:
            clear();
            break;
        }
    }

    public void insert(int digit) {
        if (check == 1) {
            clear();
        }
        display = display + Integer.toString(digit);
        if(op == 'q') {
            num = Integer.valueOf(display).intValue();
        } else {
            String[] digits = display.split("\\"+op.toString());
            num = Integer.valueOf(digits[digits.length-1]);
        }
        rd.setText(display);
        check = 0;
    }

    public void perform() {
        numtemp = num;
        display = display + op.toString();
    }

    public void calculate() {
        switch (op) {
        case '+':
            i = numtemp + num;
            break;
        case '-':
            i = numtemp - num;
            break;
        case '*':
            i = numtemp * num;
            break;
        case '/':
            i = numtemp / num;
            break;
        }
        display = Integer.toString(i);
        rd.setText("=" + display);
        check = 1;
    }

    public void clear() {
        op = 'q';
        num = 0;
        numtemp = 0;
        i = 0;
        display = "";
        rd.setText(display);
    }

}