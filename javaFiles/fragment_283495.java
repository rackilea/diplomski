LinearLayout mLinearLayout = (LinearLayout)findViewById(R.id.child_linear);
mLinearLayout.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
});