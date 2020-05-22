SharedPreferences.Editor editor; 
  // ^^^^^^^^^^  declare it outside

  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_step = (TextView) findViewById(R.id.main_text_step);
        delayHandler = new Handler(this);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editor=getSharedPreferences("DateStep",MODE_PRIVATE).edit();
        // initialize editor
    }