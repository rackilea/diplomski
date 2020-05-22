class ThreadTask implements Runnable {

    private volatile boolean shouldStop = false;

    public void run() {
        while(!shouldStop) {
            ...
        }
    }

    public void stopTask() {
        shouldStop = true;
    }
}