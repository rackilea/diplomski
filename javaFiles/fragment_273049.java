mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        onSingleTap(e);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }
});