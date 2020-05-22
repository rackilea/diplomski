protected Firebase ref;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    String firebaseUrl = getResources().getString(R.string.firebase_url);
    ref = new Firebase(firebaseUrl);

}