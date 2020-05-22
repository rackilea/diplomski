@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    heightMeasureSpec = MeasureSpec.makeMeasureSpec(containerHeight, MeasureSpec.EXACTLY);
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
}