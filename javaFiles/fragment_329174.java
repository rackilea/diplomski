interface ThreadControl {
    boolean shouldContinue();
}

class Timer implements ThreadControl {
    public boolean shouldContinue() {
        // returns false if max_time has elapsed
    }
}

class MyTask implements Runnable {
    private tc;
    public MyTask(ThreadControl tc) {
        this.tc = tc;
    }
    public void run() {
        while (true) {
            // do stuff
            if (!tc.shouldContinue())
                break;
        }
    }
}