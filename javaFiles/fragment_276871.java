myView.setOnTouchListener(new OnTouchListener() {
    public boolean onTouch(View v, MotionEvent event) {
        // ... Respond to touch events --> tv.setVisibility(View.INVISIBLE);
        return true; // if you return false with this then the listener will not be called for the subsequent ACTION_MOVE and ACTION_UP string of events.
    }
});