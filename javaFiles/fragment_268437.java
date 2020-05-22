public BlackPixel(Context context) {
    super(context);
    setFocusable(true);     
    setFocusableInTouchMode(true);
    this.setOnTouchListener(this);

    //change paint style to STROKE
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeWidth(12);
}