@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output3 = findViewById(R.id.output3);
        output3.setMovementMethod(ScrollingMovementMethod.getInstance());
        AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            connection();
        }
    });
    }