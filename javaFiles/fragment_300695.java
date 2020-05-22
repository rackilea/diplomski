@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (checkIntent()) return;

    // other code.
}

@Override
protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    checkIntent();
}

private boolean checkIntent() {
    // to receive the value, send the value as custom data from Firebase console.
    String value = getIntent().getStringExtra("your_key");

    if (value == null) return false;

    if (value.equals("something")) {
        // open one activity.

    } else if (value.equals("another_thing")) {
        // open another activity.
    }

    finish();
    return true;
}