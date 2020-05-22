public Board(String[] s, int n) {   
    playerNames=s;
    numberOfPlayers= n;
    players = new Player[numberOfPlayers];
    playerNames= new String[numberOfPlayers];
    hands = new PlayerHand[numberOfPlayers];
}