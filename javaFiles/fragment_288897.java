public class MapViewLayout extends RelativeLayout {

    private MapView mapView;

    /**
     * @see #setDetachedMode(boolean)
     */
    private boolean detachedMode;

    // implement initialization of your layout...

    private void setUpMapView() {
       mapView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (detachedMode) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        // if you want to fire another event
                    }

                    // Is detached mode is active all other touch handler
                    // should not be invoked, so just return true
                    return true;
                }

                return false;
            }
        });
    }

    /**
     * Sets the detached mode. In detached mode no interactions will be passed to the map, the map
     * will be static (no movement, no zooming, etc).
     *
     * @param detachedMode
     */
    public void setDetachedMode(boolean detachedMode) {
        this.detachedMode = detachedMode;
    }
}