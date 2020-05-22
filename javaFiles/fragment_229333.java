public class DrawView extends View implements View.OnTouchListener {
private List<Point> points = new ArrayList<>();
private Paint paint = new Paint();

public DrawView(Context c) {
    super(c);
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.setOnTouchListener(this);
    paint.setColor(Color.BLACK);
}

@Override
public void onDraw(Canvas canvas) {
    for (Point point : points) {
        canvas.drawCircle(point.x, point.y, point.radius, point.paint);
    }
}

public boolean onTouch(View view, MotionEvent event) {
    Point point = new Point();
    point.x = event.getX();
    point.y = event.getY();
    point.radius = 30;
    int c = DrawingPage.selectedColorRGB;
    point.paint = new Paint();
    point.paint.setColor(c);
    points.add(point);
    invalidate();
    return true;
}}