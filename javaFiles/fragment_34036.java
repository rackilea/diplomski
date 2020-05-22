public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.stats);

    int n = getIntent().getIntExtra(MainActivity.SOME_KEY, -1);
    TextView tvStats = (TextView) findViewById(R.id.passedNumber_textview);
    String number = String.valueOf(n);
    tvStats.setText(number);
}