@Override
protected void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);

    // ........
    // For each one of the 7 layouts you'll call the following (better create a method containing the below)
    for (int i = 0; i < layout.getChildCount(); i++) {
        View v = layout.getChildAt(i);

        if (v instanceof CheckBox) {
            ((CheckBox)v).setOnCheckedChangeListener (this);
        }
    }