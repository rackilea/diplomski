private Activity mActivity;

 public HelloItemizedOverlay(Drawable defaultMarker, Activity activity) {
  super(boundCenterBottom(defaultMarker));
  mActivity = activity;
 }

 public boolean onTouchEvent(MotionEvent event, MapView mapView) {
      mActivity.finish(); 
 }