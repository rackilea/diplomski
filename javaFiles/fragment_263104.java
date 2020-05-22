protected void onCreate(Bundle savedInstanceState) {
    if (getIntent().getBooleanExtra(EXIT_FLAG, false)) {
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY) == 0) {
            finish();
    }
}