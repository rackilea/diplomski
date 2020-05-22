package ca.kieve.playground;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class AnimView extends View {
    private int p = 0;
    private Paint mPaint;

    public AnimView(Context context) {
        super(context);
        init();
    }

    public AnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p += 1;
        canvas.drawLine(5, 5, p, 5, mPaint);
        invalidate();
    }
}