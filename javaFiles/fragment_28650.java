mWebView.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false; //returns true if you wan't also ignore the js touch events
    }
});