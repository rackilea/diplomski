public static void startGame(DrawingPanel panel, Graphics g) {
    for (int i = 0; i <= 1; i++) {
        panel.sleep(SLEEP_TIME);
        drawAll(g);
    }
}