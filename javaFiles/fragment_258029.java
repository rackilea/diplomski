public void beginGame(View view) {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    EditText gameNameField = (EditText) findViewById(R.id.gameName);
    String gameName = gameNameField.getText().toString().trim();
    Collections.shuffle(players);
    if (gameName.isEmpty()) {
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.toast_no_game_name, duration);
        toast.show();

    } else if (playerNames.size() < 2) {
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.toast_not_enough_players, duration);
        toast.show();

    } else {
        for (int i = 0; i < players.size(); i++) {
            if (i != (players.size() - 1)) {
                players.get(i).target = players.get(i + 1);
            } else {
                players.get(i).target = players.get(0);
            }
        }
        Game game = new Game(gameName, players);
        DatabaseReference gamesRef = ref.child("Games").child(gameName).child("players");
        Map<String, Player> gamePlayers = new HashMap<>();
        for(int i = 0; i < players.size(); i++){
            Player currentPlayer = players.get(i);
            gamesRef.child(currentPlayer.getName()).setValue(currentPlayer);

        }

    }
}