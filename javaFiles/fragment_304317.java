@Override
protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);
                        sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
                        String title = sharedPreferences.getString(ACTION_BAR_TITLE, "Default Title"); // your title
                        getSupportActionBar().setTitle(title);

                  }