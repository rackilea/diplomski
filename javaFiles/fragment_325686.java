@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.settings);

   Intent intent = getIntent();
   int Money = intent.getIntExtra("money", 0);