public class CustomView extends View {

private final Paint p = new Paint();
private final Paint p2 = new Paint();
private float lastRawX = 0, lastRawY = 0;
private float lastX = 0, lastY = 0;

public CustomView(Context context, AttributeSet attrs) {
    super(context, attrs);
    p.setColor(0xFFFF0000);
    p2.setColor(0xFF00FF00);
}

@Override
public boolean onTouchEvent(MotionEvent event) {
    lastX = event.getX();
    lastY = event.getY();
    lastRawX = event.getRawX();
    lastRawY = event.getRawY();
    invalidate();
    return true;
}

@Override
protected void onDraw(Canvas canvas) {
    // make the touch point big enough to be noticed.
    canvas.drawCircle(lastX, lastY, 3, p);
    canvas.drawCircle(lastRawX, lastRawY, 3, p2);
}
}