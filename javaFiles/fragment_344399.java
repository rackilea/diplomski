@Override
public boolean onTouchEvent(MotionEvent event) {
    int action = event.getAction();
    //Make sure is multi-touch...
    if (event.getPointerCount() > 1) {
        int pointerId = action & MotionEvent.ACTION_POINTER_ID_MASK;
        int actionEvent = action & MotionEvent.ACTION_MASK;
        //At this point you know the id of the touch event and what action just happened.
    }
    return super.onTouchEvent(event);
}