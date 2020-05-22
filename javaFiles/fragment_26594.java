@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
    Display display = wm.getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int height = (int) (size.y * .4);
    setMeasuredDimension(widthMeasureSpec,
                         View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));
}