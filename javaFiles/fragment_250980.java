try {
    while (running) {
        gameAction();
        Thread.sleep(200);
    }
} catch (InterruptedException e) {
    e.printStackTrace();
}