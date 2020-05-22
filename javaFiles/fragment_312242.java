import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;

public class DrawPoints extends android.support.v7.widget.AppCompatImageView {

    private static final String TAG = DrawPoints.class.getSimpleName();

    private ArrayList<Point> mSavedPoints = new ArrayList<>();
    private Point mLastTouchPoint;
    private Paint mPaint;

    public DrawPoints(Context context) {
        super(context);
        init();
    }

    public DrawPoints(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawPoints(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
    }

    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        mLastTouchPoint = new Point((int) event.getX(), (int) event.getY());
        postInvalidate();
        return super.dispatchTouchEvent(event);
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mLastTouchPoint != null) {
            if (mLastTouchPoint.x > 0 || mLastTouchPoint.y > 0) {
                mSavedPoints.add(mLastTouchPoint);
                Log.i(TAG, mLastTouchPoint.toString());
            }
        }

        for (Point point : mSavedPoints) {
            canvas.drawCircle(point.x, point.y, 200, mPaint);
        }

        Log.i(TAG, mSavedPoints.toString());
    }
}