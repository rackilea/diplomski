private void setTouchListener() {
    /** https://github.com/davemorrissey/subsampling-scale-image-view/wiki/09.-Events:
     *  ...you must check that the view is ready with the isReady() method before attempting to convert screen
     *  coordinates to image coordinates. A NullPointerException may be thrown if you don't. It is safe to override
     *  onSingleTapUp, onSingleTapConfirmed, onLongPress and onDown from the SimpleOnGestureListener class. If you
     *  override other methods, you will prevent the view from properly handling double taps, zoom and pan gestures.
     */

    final GestureDetector gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (isReady() && deeplinkCoordinates != null) {
                PointF tappedCoordinate = new PointF(e.getX(), e.getY());

                int blockWidth = deepLinkBitmap.getWidth();
                int blockHeight = deepLinkBitmap.getHeight();

                // check if deepLinkBitmap is touched
                for (PointF deeplink : deeplinkCoordinates) {
                    PointF deeplinkCoordinate = sourceToViewCoord(deeplink);
                    int deeplinkX = (int) (deeplinkCoordinate.x - (deepLinkBitmap.getWidth() / 2));
                    int deeplinkY = (int) (deeplinkCoordinate.y - deepLinkBitmap.getHeight());

                    // center coordinate -/+ blockWidth actually sets touchable area to 2x icon size
                    if (tappedCoordinate.x >= deeplinkX - blockWidth && tappedCoordinate.x <= deeplinkX + blockWidth &&
                            tappedCoordinate.y >= deeplinkY - blockHeight && tappedCoordinate.y <= deeplinkY + blockHeight) {
                        // App.toast("You tapped on a deeplink!");
                    } 
                }
            }
            return true;
        }
    });

    setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
    });
}