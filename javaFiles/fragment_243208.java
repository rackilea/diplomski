package com.example.exampleshowdigits;

import java.util.Random;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity implements OnClickListener {

    private Button mButton;
    private TextView mTextView1;
    private TextView mTextView2;
    private EditText mEditText;
    private boolean numbersShown;
    private int[] numbers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.button1);
        mTextView1 = (TextView)findViewById(R.id.textview1);
        mTextView2 = (TextView)findViewById(R.id.textview2);
        mEditText = (EditText)findViewById(R.id.edittext1);
        mButton.setOnClickListener(this);
        InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(mEditText, 0);
        numbersShown = false;
        numbers = new int[9];
    }

    @Override
    public void onClick(View v) {
        if(!numbersShown) {
            Random rand = new Random();
            String number = "";
            for(int i = 0; i < 9; i ++) {
                int num = rand.nextInt(10); //assuming you want 0-9
                numbers[i] = num;
                number += Integer.toString(num); //same as number = number + Integer.toString(num);
            }
            mTextView1.setText(number);
            SystemClock.sleep(500);
            final Runnable makeTextDisapear = new Runnable() {
                public void run() {
                    mTextView1.setText("");
                    mButton.setText(getString(R.string.checkresult));
                    mTextView2.setText(getString(R.string.whatdidyousee));
                    mEditText.setText("");
                    numbersShown = true;
                }
            };
            Handler mHandler = new Handler();
            mHandler.postDelayed(makeTextDisapear, 1000);
        }
        else {
            mButton.setText(getString(R.string.shownumbers));
            numbersShown = false;
            int correct = 0;
            String numbersEntered = mEditText.getText().toString();
            for(int i = 0; i < numbersEntered.length(); i++) {
                int num = Character.getNumericValue(numbersEntered.charAt(i));
                if(num == numbers[i]) {
                    correct++;
                }
            }
            mTextView2.setText(correct + " " + getString(R.string.correct));
        }
    }
}