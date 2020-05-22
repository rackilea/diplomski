private Toast warningToast;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Inflate the Activity's layout (optional)
    setContentView(R.layout.activity_main);

    // Initialize the toast
    warningToast = Toast.makeText(this, R.string.warning, Toast.LENGTH_LONG);
}