public class MaskView extends View implements TimeAnimator.TimeListener {
    private Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.car);
    private float y;
    private Paint carPaint = new Paint();
    private Paint maskPaint = new Paint();
    private Rect carRect = new Rect();

    public MaskView(Context context) {
        super(context);
        init();
    }

    public MaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int colors[] = {0x00000000, 0xff000000, 0xff000000, 0x00000000};
        float[] positions = {0f, 0.3f, 0.7f, 1f};
        maskPaint.setShader(new LinearGradient(0, 0, bitmap.getWidth(), h, colors, positions, Shader.TileMode.CLAMP));
        maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        carPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT));
        carRect.set(0, 0, bitmap.getWidth(), h + bitmap.getHeight());
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        TimeAnimator animator = new TimeAnimator();
        animator.setTimeListener(this);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(0, -y);
        canvas.drawRect(carRect, carPaint);
        canvas.translate(0, y);
        canvas.drawRect(carRect, maskPaint);
    }

    @Override
    public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
        y = (bitmap.getHeight() * totalTime / 1000f) % bitmap.getHeight();
        invalidate(carRect);
    }
}