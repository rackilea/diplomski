increaseWeightButton.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent mEvent) {
        if (mEvent.getAction() == MotionEvent.ACTION_DOWN)
            startIncreasingWeight();
        else if (mEvent.getAction() == MotionEvent.ACTION_UP)
            stopIncreasingWeight();
        return false;
    }
});