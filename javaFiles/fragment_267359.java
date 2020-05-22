final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
    public void onLongPress(MotionEvent e) {
        Log.e("", "Longpress detected");
    }
});

public boolean onTouchEvent(MotionEvent event) {
    return gestureDetector.onTouchEvent(event);
};