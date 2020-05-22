public class SnippetLabel extends LinearLayout {
    public SnippetLabel(Context context) {
        super(context);
        init();
    }

    public SnippetLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SnippetLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setOrientation(VERTICAL);
        ...
    }
}