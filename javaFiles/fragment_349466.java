@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnStart = (BootstrapButton) findViewById(R.id.start);
    p1 = (EditText) findViewById(R.id.player1);
    p2 = (EditText) findViewById(R.id.player2);
    p3 = (EditText) findViewById(R.id.player3);
    p4 = (EditText) findViewById(R.id.player4);
    p5 = (EditText) findViewById(R.id.player5);

    playerList.add(p1.getText().toString());
    playerList.add(p2.getText().toString());
    playerList.add(p3.getText().toString());
    playerList.add(p4.getText().toString());
    playerList.add(p5.getText().toString());

    btnStart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent myIntent = new Intent(MainActivity.this, GameActivity.class);
            myIntent.putStringArrayListExtra("player_list", playerList);
            MainActivity.this.startActivity(myIntent);
        }

    });
  }