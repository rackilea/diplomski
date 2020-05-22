public void onPlayerJoin() {
    waitForPlayers();
}

boolean isWaiting = false;

public void waitForPlayers() {
    if (!isWaiting) {
        isWaiting = true;
        new Thread("background").sleep(millis);
        // Now that we have waited, start the game
        isWaiting = false;
        game.start();
    }
}