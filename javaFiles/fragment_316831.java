public class MainFrameLayout extends FrameLayout {
    private boolean canTouch = true;

    public MainFrameLayout(@NonNull Context context) {
        super(context);
    }

    public MainFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MainFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MainFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (canTouch)
            return super.onInterceptTouchEvent(ev);
        else
            return true;
    }


    public void setCanTouch(boolean b) {
        canTouch = b;
    }
}