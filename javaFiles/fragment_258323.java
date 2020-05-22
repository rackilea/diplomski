class PieView extends SurfaceView{

    private Interval[] intervals;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF rectf;
    private int size;

    public PieView (Context context, Interval[] intervals) {
        super(context);
        this.intervals = intervals;
    setWillNotDraw(false);
    }

    @Override protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        size = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(size, size);
        if (rectf == null || rectf.width() != size ) { rectf = new RectF(0, 0, size, size); }
    }

    @Override protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
    canvas.drawColor(getResources().getColor(android.R.color.background_light));
        paint.setColor(intervals[0].color);
        canvas.drawArc(rectf, -90, 360, true, paint);
        paint.setColor(intervals[1].color);
        canvas.drawArc(rectf, -90, intervals[1].duration, true, paint);
    }
}