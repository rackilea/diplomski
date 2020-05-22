class RepaintScheduler implements Runnable {
    private boolean paused = false;
    private final Object LOCK = new Object();

    public void run() {
        while (true) {
            synchronized(LOCK) {
                if (paused) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    repaint();
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        synchronized(LOCK) {
            paused = true;
            LOCK.notifyAll();
        }
    }

    public void resume() {
        synchronized(LOCK) {
            paused = false;
            LOCK.notifyAll();
        }
    }
}