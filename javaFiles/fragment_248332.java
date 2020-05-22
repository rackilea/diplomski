ViewTreeObserver.OnGlobalLayoutListener layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        mmv.setAbShift(MunroBag.this.actionBar.getHeight());
    }
};