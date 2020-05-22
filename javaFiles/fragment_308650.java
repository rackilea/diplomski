//layout = (RelativeLayout) findViewById(R.id.layout);

layout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

    @Override
    public void onGlobalLayout() {

    // Ensure you call it only once :
        layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);

        width = layout.getWidth();// width must be declare as a field
        height = layout.getHeight;// height must be declare as a field
        levelCounter.setText("" + width);´
    }
});