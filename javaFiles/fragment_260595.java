public class MyOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

    private final View[] mViews;

    public MyOnCheckedChangeListener(View... views) {
        mViews = views
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        for (View v : mViews) {
            LinearLayout layout = (LinearLayout) v;
            if (isChecked) {
                Animation anim = expand(layout, true);
                layout.startAnimation(anim);
            } else {
                Animation anim = expand(layout, false);
                layout.startAnimation(anim);
            }
        }
    }
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // inflate layout

    // option 1
    mySwitch = (Switch) findViewById(R.id.my_switch);
    mySwitch.setOnCheckedChangeListener(
            new MyOnCheckedChangeListener(findViewById(R.id.some_view)));
    myOtherSwitch = (Switch) findViewById(R.id.my_other_switch);
    myOtherSwitch.setOnCheckedChangeListener(
            new MyOnCheckedChangeListener(findViewById(R.id.some_other_view)));

    // option 2
    mySwitch = (Switch) findViewById(R.id.my_switch);
    mySwitch.setOnCheckedChangeListener(
            new MyOnCheckedChangeListener(new View[]{
                    findViewById(R.id.some_view),
                    findViewById(R.id.some_other_view)
            }));
}