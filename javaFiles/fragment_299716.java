public class ChinLayout extends FrameLayout {

    public ChinLayout(Context context) {
        super(context);
    }

    public ChinLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChinLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChinLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        int chin = insets.getSystemWindowInsetBottom();
        setPadding(0, 0, 0, chin);
        return insets;
    }
}