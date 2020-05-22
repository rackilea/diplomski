public class ScoreTextView extends TextView {
    private CharSequence mScore;

    public ScoreTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!isFocusable()) {
            mScore = text;
        }
        super.setText(text, type);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            setFocusable(false);
            setFocusableInTouchMode(false);
            setText(mScore);
        }
        return super.onKeyPreIme(keyCode, event);
    }
}