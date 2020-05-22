public class ParentLayout extends RelativeLayout implements View.OnClickListener {

    public ParentLayout(Context context) {
        super(context);
        init();
    }

    public ParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ParentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    // handle focus and click states
    public void init() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnClickListener(this);
    }

    // when positioning all children within this 
    // layout, add their focusable state
    @Override
    protected void onLayout(boolean c, int l, int t, int r, int b) {
        super.onLayout(c, l, t, r, b);

        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            child.setFocusable(true);
            child.setFocusableInTouchMode(true);
        }
        // now, even the Button has a focusable state
    }

    // handle the click events
    @Override
    public void onClick(View view) {
        // clear and set the focus on this viewgroup
        this.clearFocus();
        this.requestFocus();
        // now, the focus listener in Activity will handle
        // the focus change state when this layout is clicked
    }
}