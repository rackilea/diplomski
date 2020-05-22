class Player {

    String name;
    Type type;

    public Player(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}

Player[] playersList = { new Player("playerA", Type.HUMAN), new Player("playerB", Type.AI)};
for (Player player: playersList) {
    if (player.type == Type.AI) {
            AIPlayer aiPlayer = AIPlayer.class.getConstructor(String.class).newInstance(player.name);
            aiPlayer.addObserver(gameModelObserver);
            players.add(aiPlayer);                                    }
    else {
            HumanPlayer humanPlayer = HumanPlayer.class.getConstructor(String.class).newInstance(player.name);
            humanPlayer.addObserver(gameModelObserver);
            players.add(humanPlayer);
    }

}