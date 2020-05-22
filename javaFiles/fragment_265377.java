public class VersatileSeekBar extends SeekBar implements SeekBar.OnSeekBarChangeListener {
    private TextView mTextView;
    private ChangeHandler mChangeHandler;

    public void bindDisplayToChange(TextView textView,ChangeHandler handler) {
        mTextView = textView;
        mChangeHandler = handler;
    }

    public VersatileSeekBar(Context context) {
        super(context);
        init();
    }

    public VersatileSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VersatileSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(mChangeHandler != null && mTextView != null){
            mChangeHandler.onChange(i,mTextView);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    private void init(){
        this.setOnSeekBarChangeListener(this);
    }

    public static abstract class ChangeHandler{
        public abstract void onChange(int value,TextView textView);
    }
}