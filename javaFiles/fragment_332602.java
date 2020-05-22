public MyView(Context context) {
    super(context);
    init();
}

public MyView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
}

private void init() {
    p=new Paint();
    p.setAntiAlias(true);
    ct=new Paint();
    ct.setAntiAlias(true);
}