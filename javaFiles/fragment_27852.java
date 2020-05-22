public class RectangleTextView extends View {
    private final Paint mBlackPaint = new Paint();
    private final Paint mRedPaint = new Paint();
    private final TextPaint mTextPaint;

    public RectangleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        int valueInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics());
        int valueInSp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics());

        mRedPaint.setColor(Color.parseColor("#CC3333"));

        mBlackPaint.setAntiAlias(false);
        mBlackPaint.setColor(Color.BLACK);
        mBlackPaint.setStrokeWidth(valueInDp);
        mBlackPaint.setStyle(Paint.Style.STROKE);

        mTextPaint = new TextPaint(TextPaint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(valueInSp);

        mWindowPaint = new Paint();
        mWindowPaint.setColor(Color.parseColor("#CC3333"));
        mWindowPaint.setStrokeWidth(valueInDp);
    }

    private Paint mWindowPaint;
    Rect rect = new Rect();
    Rect rect2 = new Rect();

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() == 0)
            return;

        //initialise red rectangles
        int w = canvas.getWidth();
        int h = canvas.getHeight();

        int rectWidth = ((w - 20) / 7) / 5;
        int space = ((w - 20) / 7) / 15;
        int topRectHeight = getPaddingTop();
        int bottomRectHeight = getPaddingBottom();


        //draw end rectangles
        int mSideRectWidth = 10;
        canvas.drawRect(0, 0, mSideRectWidth, getHeight(), mRedPaint); //draw left end rectangle
        canvas.drawRect(getWidth() - mSideRectWidth, 0, getWidth(), getHeight(), mRedPaint); //draw right end rectangle

        //draw grey boxes
        setBackgroundColor(Color.parseColor("#808080"));
        int boxWidth = (getWidth() - mSideRectWidth) / 7;

        //draw text views
        for (int i = 0; i < 7; i++) {
            canvas.drawText(Integer.toString(i + 1), (i * boxWidth + 10) + (boxWidth / 2), ((canvas.getHeight() / 2) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2)), mTextPaint);
        }

        //draw black lines
        for (int i = 1; i < 7; i++) {
            canvas.drawLine(mSideRectWidth + boxWidth * i, 0, mSideRectWidth + boxWidth * i, getHeight(), mBlackPaint);
        }

        //draw red windows
        for (int index = 0; index < 7; index++) {

            if (index == 0 || index == 6) {
                for (int i = 0; i < 3; i++) {
                    mWindowPaint.setStyle(Paint.Style.STROKE);//add this

                    int left = (i * (rectWidth + space)) + (index * boxWidth) + 13 + rectWidth/2 + space/2;
                    int right = left + rectWidth;

                    rect.set(left, 0, right, topRectHeight);
                    canvas.drawRect(rect, mWindowPaint);

                    if (index == 0 && i == 1) {
                        mWindowPaint.setStyle(Paint.Style.FILL); // change to this
                    }
                    rect2.set(left, h - bottomRectHeight, right, h);
                    canvas.drawRect(rect2, mWindowPaint);

                }

            } else {
                for (int i = 0; i < 4; i++) {
                    mWindowPaint.setStyle(Paint.Style.STROKE);//add this
                    int left = (i * (rectWidth + space)) + (index * boxWidth) + 13;
                    int right = left + rectWidth;

                    rect.set(left, 0, right, topRectHeight);

                    canvas.drawRect(rect, mWindowPaint);

                    rect2.set(left, h - bottomRectHeight, right, h);
                    canvas.drawRect(rect2, mWindowPaint);
                }
            }
        }
    }
}