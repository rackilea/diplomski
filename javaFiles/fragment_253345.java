public void texting(String inc) {
    Thread t = new Thread(() -> {
        try {
            for (int i = 1; i <= inc.length(); i++) {
                String text = inc.substring(0, i);
                Platform.runLater(() -> labelHeader.setText(text));
                Thread.sleep(300);
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    });
    t.setDaemon(true); // thread will not stop application exit
    t.start();
}