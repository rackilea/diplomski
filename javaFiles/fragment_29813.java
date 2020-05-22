img.setOnTouchListener(new MyTouchDetector(mContext,this));


public class MyTouchDetector extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    int position;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private ClickDetector clickDetector;



    public MyTouchDetector(Context mContext, ClickDetector clickDetector) {
        this.mGestureDetector = new GestureDetector(mContext, this);
        this.clickDetector = clickDetector;
    }
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d("onDoubleTap :", "" + e.getAction());
        clickDetector.doubleClick();
        return super.onDoubleTap(e);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d("onSingleTap :", "" + e.getAction());
        clickDetector.singleClick();
        return super.onSingleTapConfirmed(e);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        //return super.onDown(e);
        return true;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
    @Override
    public void onLongPress(MotionEvent e) {
        super.onLongPress(e);
        Log.d("onLongPress :", "" + e.getAction());

    }