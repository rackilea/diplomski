public class MyNumberPicker extends android.widget.NumberPicker {
    private final String TAG = MyNumberPicker.class.getSimpleName();
    View.OnFocusChangeListener mOnFocusChangeListener;

    public MyNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setOnFocusChangeListener(View.OnFocusChangeListener listener){
        mOnFocusChangeListener = listener;
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        Log.d(TAG,"onFocusChanged called by the view system");
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (mOnFocusChangeListener != null) {
            mOnFocusChangeListener.onFocusChange(this, gainFocus);
        }
    }
}