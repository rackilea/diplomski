void play(Player p) {
    Result r = p.play(this);
    GameState gameState = new GameState();
    gameState.currentGameProperty().addListener((obs, oldGame, newGame) -> {
        newGame.finishedProperty().addListener((obs, wasFinished, isNowFinished) -> {
            if (isNowFinished) {
                // maybe update score etc based on state of newGame...
                if (gameState.hasMoreGames()) {
                    gameState.nextGame();
                } else {
                    // logic here for "all games are finished...
                }
            }
        });
    });
    gameState.start();
}