public final class CustomView extends FrameLayout {
    public CustomView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_item, this);
    }

    public void bind(String name, int value) {
        TextView textView = (TextView)getRootView().findViewById(R.id.titleTextView);
        LinearLayout containerLinearLayout = (LinearLayout)getRootView().findViewById(R.id.containerLinearLayout);

        textView.setText(name);
        containerLinearLayout.removeAllViews();

        for (int i = 0; i < value; i++) {
            containerLinearLayout.addView(new NestedCustomView(getContext()));
        }
    }
}