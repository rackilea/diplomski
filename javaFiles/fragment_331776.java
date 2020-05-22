@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Intent intent = getIntent();

    if (intent.hasExtra(Constants.KEY_MESSAGE_TXT)) {
        String message = intent.getStringExtra(Constants.KEY_MESSAGE_TXT);
        Log.d(TAG, message);
    } 
}