private GestureDetector gd =
            new GestureDetector(getContext(), new SimpleOnGestureListener() {
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                            float distanceX, float distanceY) {
        setPadding((int)(getPaddingLeft()+distanceX),0,0,0);
    }
    @Override
    public boolean onDown(MotionEvent e) {
        return true; // else no event will be handled
    }