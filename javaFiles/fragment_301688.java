public class MapOverlay {

    private GeoPoint pointToDraw;
    int[] imageNames=new int[6];
    // This is the cached Point on the screen that will get refilled on every draw
    private Point mScreenPoints;
    // This is the cached decoded bitmap that will be drawn each time
    private Bitmap mBitmap;
    // Cached Paint
    private Paint mCirclePaint;

    public MapOverlay(GPSLocationListener gpsLocationListener, int currentUser) {
      imageNames[0]=currentUser;
      // This only needs to be made here, once. It never needs to change.
      mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
      mCirclePaint.setColor(0x30000000);
      mCirclePaint.setStyle(Style.FILL_AND_STROKE);
      // We only need to load this image once and then just keep drawing it when dirtyed.
      mBitmap = BitmapFactory.decodeResource(context.getResources(),imageNames[0]);
      // This Point object will be changed every call to toPixels(), but the instance can be recycled
      mScreenPoints = new Point();
    }

    public void setPointToDraw(GeoPoint point) {
      pointToDraw = point;
    }

    public GeoPoint getPointToDraw() {
      return pointToDraw;
    }

    public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) {
      super.draw(canvas, mapView, shadow);
      // In the case where nothing has been set yet, don't do any drawing
      if (pointToDraw == null) {
         return true;
      }
      //--------------draw circle----------------------
      mScreenPoints = mapView.getProjection().toPixels(pointToDraw, mScreenPoints);

      int totalCircle=4;
      int radius=40;
      int centerimagesize=35;

      for (int i = 1; i <= totalCircle; i ++) { 
          canvas.drawCircle(screenPts.x,screenPts.y, i*radius, mCirclePaint); 
      } 

      canvas.drawBitmap(mBitmap, (screenPts.x-(centerimagesize/2)),(screenPts.y-(centerimagesize/2)), null);
      super.draw(canvas,mapView,shadow);

      return true;
    }