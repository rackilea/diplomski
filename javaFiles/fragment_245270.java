class FrameView extends View {

    private Bitmap mBitmap;

    public FrameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Your drawing logic
        canvas.drawBitmap(mBitmap,0,0, null);
    }

    private void setFrame(final Bitmap b){
        if (mBitmap!=null){
            mBitmap.recycle();
        }
        mBitmap = b;
        //trigger onDraw, if this method is not called from a ui thread switch to postInvalidate()
        this.invalidate();
    }
}