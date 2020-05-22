public static class Sync implements Runnable {

    private AtomicBoolean keepRunning = new AtomicBoolean(true);
    private AtomicBoolean pause = new AtomicBoolean(false);

    private ReentrantLock lckPause = new ReentrantLock();
    private Condition conPause = lckPause.newCondition();

    public void run() {
        while (keepRunning.get() && !Thread.currentThread().isInterrupted()) {
            while (pause.get() && !Thread.currentThread().isInterrupted()) {
                lckPause.lock();
                try {
                    System.out.println("Paused");
                    conPause.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    lckPause.unlock();
                }
            }
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello");
                try {

                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }
            }
        }
    }

    public void setPaused(boolean paused) {
        if (pause.get() != paused) {
            pause.set(paused);
            if (!paused) {
                lckPause.lock();
                try {
                    conPause.signal();
                } finally {
                    lckPause.unlock();
                }
            }
        }
    }

    public void terminate() {
        keepRunning.set(false);
        setPaused(false);
    }

}