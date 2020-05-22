protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game_start);
    tvScore= (TextView) findViewById(R.id.tvGuessGame);
    SharedPreferences settings = getSharedPreferences(....); //
    int highscore = settings.getInt("highscore", 0);
    tvScore.setText(""+highscore);
}