abstract class PausableTask implements Runnable {
    private volatile boolean paused;
    private final Object lock = new Object();

    void setPaused(boolean shouldPause) {
        synchronized (lock) {
            paused = shouldPause;
            if (!paused) {
                lock.notify();
            }
        }
    }

    boolean isPaused() { return paused; }

    @Override
    public void run() {

        for (;;) {                
            synchronized (lock) {
                while (paused) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {}
                }
            }

            doTask();
        }
    }

    abstract void doTask();
}

class Counter {
    volatile long count;

    public static void main(String[] args) {
        final Counter counter = new Counter();

        PausableTask increment = new PausableTask() {
            @Override
            void doTask() {
                counter.count++;
            }
        };

        PausableTask decrement = new PausableTask() {
            @Override
            void doTask() {
                counter.count--;
            }
        };

        decrement.setPaused(true);
        PausableTask next = increment;

        Scanner in = new Scanner(System.in);
        long count = counter.count;

        new Thread(increment).start();
        new Thread(decrement).start();

        for (;;) {
            System.out.print(
                (next == increment ? "Counting up from " : "Counting down from ")
                + count + ". Enter 'exit' to abort or anything else to toggle: "
            );

            if (in.nextLine().equals("exit")) {
                System.exit(0);
            }

            if (increment.isPaused()) {
                next = increment;
                decrement.setPaused(true);
            } else {
                next = decrement;
                increment.setPaused(true);
            }

            count = counter.count;
            next.setPaused(false);
        }
    }
}