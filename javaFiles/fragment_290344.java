import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class RotateCircleView extends View {
    static final double TAU = Math.PI * 2;
    Paint paint;
    double angle = 0;
    double radius = 0;
    double ix = Double.NaN, iy = Double.NaN;

    public RotateCircleView(Context context) {
        super(context);
        init();
    }
    public RotateCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public RotateCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init() {
        paint = new Paint();
        paint.setAlpha(100);
        paint.setStrokeWidth(20);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        ix = w / 2.0;
        iy = h / 2.0;
        radius = Math.min(ix, iy) / 2.0;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (Double.isNaN(ix)) return;
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate((float) ((TAU * -angle) / 360.0), (float) ix, (float) iy);
        canvas.drawCircle((float) ix, (float) iy, (float) radius, paint);
        double limit = TAU / 6.0;
        if (angle > limit) angle = limit;
        if (angle < -limit) angle = -limit;
        double tx = ix + Math.cos(angle) * radius;
        double ty = iy + Math.sin(angle) * radius;
        canvas.drawLine((float) ix, (float) iy, (float) tx, (float) ty, paint);
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent event) {
        double mx = event.getX();
        double my = event.getY();
        double dx = mx - ix;
        double dy = my - iy;
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                //radius = Math.sqrt(dx * dx + dy * dy);
                angle = Math.atan2(dy, dx);
                invalidate();
                break;
        }
        return true;
    }
}