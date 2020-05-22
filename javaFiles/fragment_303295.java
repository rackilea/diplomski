public YahtzeeGame(int numberOfPlayers) {
    this(getUnnamedPlayers(numberOfPlayers));
}

private static String[] getUnnamedPlayers(int numberOfPlayers) {
    String[] playerNames = new String[numberOfPlayers];
    for (int i = 0; i < numberOfPlayers; i++) {
        playerNames[i] = "Unnamed player " + (i+1);
    }
    return playerNames;
}