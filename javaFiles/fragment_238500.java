public class ExpandedToolbar extends AppBarLayout {
    public ExpandedToolbar(Context context) {
        super(context);
        init();
    }

    public ExpandedToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.MyToolbar,
                0, 0);

        try {
            String title = a.getString(R.styleable.MyToolbar_toolbarTitle);
            ((Toolbar) findViewById(R.id.expanded_toolbar)).setTitle(title);
        } finally {
            a.recycle();
        }
    }

    private void init() {
        inflate(getContext(), R.layout.expanded_toolbar, this);
    }
}