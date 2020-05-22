private void start() {
    setFocusable(true);
    while (true) {
        this.requestFocusInWindow();
        update();
        render();
        try {
            Thread.sleep(16);
        } catch (InterruptedException ex) {
        }
    }
}