package com.mycompany.myapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.view.MotionEvent;

import com.mycompany.myapp.R;

public class BlueOffsetButton extends Button {

    public BlueOffsetButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public BlueOffsetButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BlueOffsetButton(Context context) {
        super(context);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        //If not clickable
        if(!this.isClickable()){
            //Do nothing
            return value;
        }

        //If clickable

        //If the button needs to go up (released)
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //Set the proper background
            setBackgroundResource(R.drawable.blue_button_normal);
            //Restore the initial padding (0, 0, 0, 0)
            setPadding(getPaddingLeft(), getPaddingTop() - 10, getPaddingRight(), getPaddingBottom() + 10);
        }

        //If the button needs to go down (pressed)
        else if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //Set the proper background
            setBackgroundResource(R.drawable.blue_button_pressed);
            //Set the proper padding to center the text (0, 10, 0, -10)
            setPadding(getPaddingLeft(), getPaddingTop() + 10, getPaddingRight(), getPaddingBottom() - 10);
        }

        return value;
    }
}