yourView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() { 

    @Override 
    public void onGlobalLayout() { 
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            yourView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            yourView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } 
        // Correct view dimensions are here:
        int width  = yourView.getMeasuredWidth();
        int height = yourView.getMeasuredHeight(); 
    } 
});