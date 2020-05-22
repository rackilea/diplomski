public void startGame(View view) {
    EditText editText1 = (EditText) findViewById(R.id.editText1);
    String namePlayer1 = editText1.getText().toString();
    int scorePlayer1 = 0;
    Player player1 = new Player(namePlayer1, scorePlayer1);
    EditText editText2 = (EditText) findViewById(R.id.editText2);
    String namePlayer2 = editText2.getText().toString();
    int scorePlayer2 = 0;
    Player player2 = new Player(namePlayer2, scorePlayer2);

    Intent intent = new Intent(this, ScoreScreen.class);
    Bundle bundle = new Bundle();
    bundle.putParcelable("EXTRA_PLAYER_1", player1);
    bundle.putParcelable("EXTRA_PLAYER_2", player2);
    intent.putExtras(bundle);
    startActivity(intent);
}


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...
    Player player1;
    Player player2;
    if (getIntent().getExtras() != null) {
        player1 = getIntent().getExtras().getParcelable("EXTRA_PLAYER_1");
        player2 = getIntent().getExtras().getParcelable("EXTRA_PLAYER_2");
    }
}