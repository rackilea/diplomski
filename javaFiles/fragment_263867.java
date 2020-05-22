public void run() {
    while (true) {
        gameMain.updateGameState();
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}