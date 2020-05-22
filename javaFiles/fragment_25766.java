expiryDate.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
    @Override
    public boolean onPreDraw() {
        expiryDate.animate().translationY(-expiryDate.getHeight());
        expiryDate.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
});