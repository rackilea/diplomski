@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    playerName = (TextView) findViewById(R.id.playerName);

    Intent myIntent = getIntent();
    if(myIntent != null){
            ArrayList<String> players = myIntent.getStringArrayListExtra("player_list");
            playerName.setText(players.get(0));
        }else{
            System.out.println("Error!");
        }
      }