private int strokeColor;

public MyCustomView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    ...

    TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyCustomView, 0, 0);
    this.strokeColor = a.getColor(R.styleable.MyCustomView_strokeColor, defaultColor);
    ...
    a.recycle();
}

public int getStrokeColor() {
    return strokeColor;
}