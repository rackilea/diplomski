public class EditTextExtra extends EditText {
    private Rect Rect;
    private Paint Paint;

    public EditTextExtra (Context context, AttributeSet attrs) {
        super(context, attrs);
        Rect = new Rect();
        Paint = new Paint();
        Paint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint.setColor(Color.BLACK);       
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int count = getHeight()/getLineHeight();
        if(getLineCount() > count){
            count = getLineCount();   // for long text with scrolling
        }
        Rect r = Rect;
        Paint paint = Paint;

        int baseline = getLineBounds(0, r); // first line

        for (int i = 0; i < count; i++) {
            canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
            baseline += getLineHeight(); // next line
        }
        super.onDraw(canvas);
    }
}