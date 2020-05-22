@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    session = new Session(this);
    loggedinusername = this.getIntent().getStringExtra(LoginActivity.INTENTEXTRAKEY_LOGGEDINUSERNAME); //<<<<<<<<<<ADDED