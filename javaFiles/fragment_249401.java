public void StopView() {

    if (gameLoopThread != null) {
        gameLoopThread.setRunning(false);

    }
}