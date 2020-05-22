@Override
public Object instantiateItem(View container, int position) {
    Context context = collection.getContext();
    LinearLayout layout = new LinearLayout(context);
    TextView view = new TextView(context);

    switch (position) {

    case 0:
       view.setText("some text");
       view.setPadding(5, 5, 5, 5);
       view.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
       break;
    case 1:
       view.setText("some text");
       view.setPadding(5, 5, 5, 5);
       view.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
       break;
    case 2:
       view.setText("some text");
       view.setPadding(5, 5, 5, 5);
       view.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
       break;
    }
    layout.addView(view);
    ((ViewPager) container).addView(layout, 0); // This is the line I added
    return layout;
}