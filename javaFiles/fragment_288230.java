public class AKChangeColorTextView extends TextView {
    public AKChangeColorTextView(Context context) {
        this(context,null);
    }
    String TAG = "AKChangeColorTextView";
    public AKChangeColorTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    RectF mRectF;
    float mX;
    float mY;
    public AKChangeColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        PorterDuffXfermode mode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mPaint.setXfermode(mode);
        float x = 60;
        float y = 10;
        mY =    0;
        mRectF = new RectF(x, y, x + 50, y + 50);
        mTPaint = getPaint();
        mX = 0;
    }

    Paint mPaint;
    TextPaint mTPaint;
    Bitmap shadowBitmap ;
    Rect bounds = new Rect();
    Canvas textCanvas;

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        if (shadowBitmap == null) {
            shadowBitmap = Bitmap.createBitmap(getMeasuredWidth(),getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        }
        if (textCanvas == null) {
            textCanvas = new Canvas(shadowBitmap);
        }
        textCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        if (mTPaint == null) {
            mTPaint = getPaint();
        }
        String content  = getText().toString();
        mTPaint.getTextBounds(content,0,content.length(),bounds);
        textCanvas.drawText(content,0,bounds.height(),mTPaint);
        mRectF.set(colorLeft,mY,colorRight,mY+bounds.height()+10);
        textCanvas.drawRect(mRectF,mPaint);
        canvas.drawBitmap(shadowBitmap,0,0,null);
    }
    float colorLeft;
    float colorRight;
    public void setXOffset(float left,float right){
        colorLeft = left;
        colorRight = right;
        invalidate();
    }

}