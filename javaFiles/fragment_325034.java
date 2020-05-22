class TimingAction implements Runnable {
    private boolean running;
    private long start;
    private long elapsed;

    public void run() {
        if (running) {
            elapsed = System.nanoTime() - start;
            running = false;
        } else {
            start = System.nanoTime();
            running = true;
        }
    }
    ...
}

TimingAction timer = new TimingAction();
CyclicBarrier cyclicBarrier = new CyclicBarrier(count + 1, timer);
...
long elapsed = timer.getElapsed();