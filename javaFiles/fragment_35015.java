...
setContextView(R.layout.activity_puzzle_picker);

final View view = findViewById(R.id.pickshapes);
view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        int height = view.getMeasuredHeight();
        if(height > 0) {
            // do whatever you want with the measured height.
            setMyViewHeight(height);

            // ... and ALWAYS remove the listener when you're done.
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }                          
    }
});
...