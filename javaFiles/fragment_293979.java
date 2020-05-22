new Thread(new Runnable() {
    public void run() {
        repaint();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
    }
}).start();