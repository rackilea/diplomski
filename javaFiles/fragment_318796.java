private void init(Context context, AttributeSet attrs, int defStyleAttr) {
    if (attrs != null) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.SeekBarButton, defStyleAttr, 0);
        mSeekbarId = a.getResourceId(R.styleable.SeekBarButton_seekbarId, 0);
        a.recycle();
    }
}