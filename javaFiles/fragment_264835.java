public class CompassActivity extends Activity {  

  public class OuterCircle extends View {
    Paint paint = new Paint();
    Path path = new Path();
    private static final String s = "Hello world example";

    public OuterCircle(Context context) {
      super(context);
      init();
    }

    private void init() {
      paint.setColor(Color.WHITE);
      paint.setStyle(Style.STROKE);
      paint.setStrokeWidth(2);
      paint.setAntiAlias(true);
    }

    private void drawDegreesOnCircle(Canvas c) {
      path.addCircle(getWidth()/2, getHeight()/2, 180, Direction.CW);
      c.drawTextOnPath(s, path, 0, 10, paint);
      setLayerType(View.LAYER_TYPE_SOFTWARE, null); // Required for API level 11 or higher.
    }

    public void onDraw(Canvas c) {      
      int cx = getWidth()/2;
      int cy = getHeight()/2;
      c.drawCircle(cx, cy, 170, paint);      
      drawDegreesOnCircle(c);
    } 
  }
}