final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
    public void onLongPress(MotionEvent e) {
        // The code for when a long-press happens
    }
});

@Override
public boolean dispatchTouchEvent(MotionEvent event) {
    gestureDetector.onTouchEvent(event);
    return super.dispatchTouchEvent(event);
}