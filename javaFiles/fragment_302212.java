package com.example.mylayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    private MyButton objbutton;

    public MyView(Context context) {
        // TODO Auto-generated constructor stub
        super(context);
    }

    public void setMyButton(MyButton myButton) {
        objbutton = myButton;
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("I am from MyView: dispatchTouchEvent");
        if(objbutton != null)
            objbutton.dispatchTouchEvent(event);
        return false;
    }

}