public Game() {
    player1 = new Player(1,0);   // create a new Player
    player2 = new Player(2,1);
    player3 = new Player(3,1);
    thisDeck = new Deck();
    currentCard = null;
    startGame();
}

public Player(int pPlayerID, int pPlayerType) {
    playerID = pPlayerID;
    playerType = pPlayerType;
    thisDeck = new Deck();
    thisGame = new Game();           // create a new Game (really??)
    hand = new ArrayList<Card>();
    handToPlay = new ArrayList<Card>();
}