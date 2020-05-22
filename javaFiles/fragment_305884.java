// initialize the Gesture Detector
gd = new GestureDetector(this,new OnGestureListener() {
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
            float velocityY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }
});

// set the on Double tap listener
gd.setOnDoubleTapListener(new OnDoubleTapListener() {
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Toast.makeText(SplashActivity.this,"Double Tap",Toast.LENGTH_LONG).show();
    return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        // if the second tap hadn't been released and it's being moved

        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

});