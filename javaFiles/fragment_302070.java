public final class NestedCustomView extends FrameLayout {
    public NestedCustomView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_nested_item, this);
    }
}