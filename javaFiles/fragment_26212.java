final View theParent = parent;
final TextView theText = textView;
textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        theText.post(new Runnable() {
            public void run() {
                // Now height is ready
                theText.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, (theParent.getHeight() / numRows)));
            }
        });
    }
});