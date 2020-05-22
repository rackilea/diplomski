@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit);

    Toolbar toolbar = (Toolbar) findViewById(toolbar);
    setSupportActionBar(toolbar);

    actionBar = (ActionBar) getSupportActionBar();
}