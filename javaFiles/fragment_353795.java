@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_score);
    textFinal = (TextView)findViewById(R.id.textFinal);
    int defaultValue = 0;
    int score = getSharedPreferences("APP", MODE_PRIVATE).getInt("SOME_IDENTIFIER", defaultValue);
    textFinal.setText(score);

}