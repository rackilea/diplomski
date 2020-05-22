class MyOverlay extends Overlay 
{
  public MyOverlay() {
  }
  public void draw(Canvas canvas, MapView mapv, boolean shadow) {
   super.draw(canvas, mapv, shadow);
   Paint mPaint = new Paint();
   mPaint.setDither(true);
   mPaint.setColor(Color.RED);
   mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
   mPaint.setStrokeJoin(Paint.Join.ROUND);
   mPaint.setStrokeCap(Paint.Cap.ROUND);
   mPaint.setStrokeWidth(100);
   for (int i = 0; i < numPoints - 1; i++) {
    float latiA = (float) Double.parseDouble(latlong[i].getLat());
    float longiA = (float) Double.parseDouble(latlong[i].getLon());
    float latiB = (float) Double.parseDouble(latlong[i + 1].getLat());
    float longiB = (float) Double.parseDouble(latlong[i + 1].getLon());
    //distance = getDistance(latiA, longiA, latiB, longiB);
    int latA = (int) (1000000 * Double.parseDouble(latlong[i].getLat()));
    int longA = (int) (1000000 * Double.parseDouble(latlong[i].getLon()));
    int latB = (int) (1000000 * Double.parseDouble(latlong[i + 1].getLat()));
    int longB = (int) (1000000 * Double.parseDouble(latlong[i + 1].getLon()));
    GeoPoint gP1 = new GeoPoint(latA, longA);
    GeoPoint gP2 = new GeoPoint(latB, longB);
    Point p1 = new Point();
    Point p2 = new Point();
    Path path = new Path();
    projection.toPixels(gP1, p1);
    projection.toPixels(gP2, p2);
    path.moveTo(p2.x, p2.y);
    path.lineTo(p1.x, p1.y);
    canvas.drawPath(path, mPaint);
   }
    }
}