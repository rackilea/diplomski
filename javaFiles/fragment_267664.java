@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.start_game);

    Intent i = getIntent();

    TextView numOfPlayersVal = (TextView) findViewById(R.id.txt2);
    numOfPlayersVal.setText(i.getStringExtra("players"));
}