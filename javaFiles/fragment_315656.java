package com.example.stack2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ButtonView extends View{
    public ButtonView(Context context, int k) {
        super(context);
        //this.setX(20+k*80);
        init();
    }

    public ButtonView(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        // TODO Auto-generated constructor stub
    }

    public ButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
    }

    public ButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public ButtonView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    Paint paint;
    private void init(){
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(20); 
    }
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //e.measure(0, 0);
        getLayoutParams().width=100;
    }
    @Override
    protected void onDraw(Canvas cv){
        super.onDraw(cv);

        cv.drawText(""+getX(), 0, cv.getHeight()/2, paint);
    }
}