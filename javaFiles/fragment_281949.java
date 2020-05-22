class SampleLayoutDemo extends LinearLayout {

public SampleLayoutDemo(Context context) {
    super(context);

    TextView view = new TextView(context);
    view.setText("Sample");
    view.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
    addView(view);
    setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
 }

}