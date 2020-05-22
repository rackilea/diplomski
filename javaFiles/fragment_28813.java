public LinedEditText(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

}

public LinedEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    mRect = new Rect();
    mPaint = new Paint();
    mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

}

public LinedEditText(Context context) {
    super(context);

}