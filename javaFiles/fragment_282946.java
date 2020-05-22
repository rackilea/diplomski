package com.test.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawText extends View {
    Paint paint = new Paint();

    private void init() {
        paint.setColor(Color.BLACK);
    }

    public DrawText(Context context) {
        super(context);
        init();
    }

    public DrawText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(40f);
        canvas.drawText("Text", 100, 100, paint);
    }

}