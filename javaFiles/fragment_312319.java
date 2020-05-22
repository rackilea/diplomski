package com.example.test;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyReusableButton extends Button {

    //use this constructor for button creation from java code
    public MyReusableButton(Context context) {
        super(context);
        init();
    }

    //this is needed for XML inflation
    public MyReusableButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //set button style
    private void init() {
        setBackgroundColor(Color.RED);
        setTextColor(Color.WHITE);
    }

    //helper to set margins
    public void setMargins(int left, int top, int right, int bottom) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(left, top, right, bottom);
        this.setLayoutParams(params);
    }
}