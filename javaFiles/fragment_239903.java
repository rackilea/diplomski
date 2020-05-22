onCreate(Bundle savedInstanceState) {
    String spinnerString;
    if (getIntent() != null && getIntent().getExtras() != null) {
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("KEY_SPINNER_STRING") != null) {
            spinnerString = bundle.getString("KEY_SPINNER_STRING");
        }
    }
}