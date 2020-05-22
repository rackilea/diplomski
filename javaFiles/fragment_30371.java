imageView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

    public void onGlobalLayout() {
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        int x = imageView.getLeft();
        int y = imageView.getTop();

        // don't forget to remove the listener to prevent being called again 
        // by future layout events:
        imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
});