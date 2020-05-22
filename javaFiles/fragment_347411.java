private int count;
    private volatile boolean stop;
    private volatile boolean stopped;

    @Override
    public void run() {
        while (!stop) {
            count++; // the work
        }
        stopped = true;
        System.out.println("Count 1 = " + count);
    }

    public void stopCounting() {
        stop = true;
        while(!stopped)
           ; //busy wait; ok in this example
    }

    public int getCount() {
        if (!stopped) {
            throw new IllegalStateException("not stopped yet.");
        }
        return count;
    }

}