public class ClippedCircleView extends android.support.v7.widget.AppCompatImageView {

    public static final String TAG = "ClippedCircle";
    private static final int INNER_EDGE_WEIGHT = 2;
    private static final int OUTER_EDGE_WEIGHT = 3;

    private int measuredWidth;
    private int measuredHeight;
    private Paint innerPaint;
    private Paint outerPaint,;
    private Paint textPaint;
    private Path path;

    public ClippedCircleView(Context context) {
        super(context);
        init();
    }

    public ClippedCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClippedCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setWillNotDraw(false);

        path = new Path();

        innerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        innerPaint.setColor(Color.GREEN);
        innerPaint.setStyle(Paint.Style.FILL);
        outerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        outerPaint.setColor(Color.WHITE);
        outerPaint.setStyle(Paint.Style.FILL);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(getResources().getDimensionPixelSize(R.dimen.clipped_circle_textsize));

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        measuredWidth = right - left;
        measuredHeight = bottom - top;
        float innerEdgeLength = INNER_EDGE_WEIGHT/ (OUTER_EDGE_WEIGHT * 1.0f) * measuredHeight;
        path.moveTo(0,0);
        path.lineTo(0, innerEdgeLength);
        float deviation = getResources().getDimensionPixelSize(R.dimen.clipped_circle_deviation);
        path.quadTo(measuredWidth*0.5f, innerEdgeLength + deviation, measuredWidth, innerEdgeLength);
        path.lineTo(measuredWidth, 0);
        path.lineTo(0,0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, measuredWidth, measuredHeight, outerPaint);
        canvas.drawPath(path, innerPaint);
        canvas.drawText("Hello!", 32, 80, textPaint);
        canvas.drawText("Welcome to", 32, 160, textPaint);
        canvas.drawText("My App", 32, 240, textPaint);
        super.onDraw(canvas);
    }
}