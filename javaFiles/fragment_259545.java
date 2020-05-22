container.post(new Runnable() {
    @Override
    public void run() {
        imageView.getLayoutParams().height = container.getWidth();
        imageView.requestLayout();
    }
});