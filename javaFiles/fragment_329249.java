public static ScheduledExecutorService timerFrameExecutor = Executors.newSingleThreadScheduledExecutor();
public static ScheduledExecutorService shortTimeExecutor = Executors.newSingleThreadScheduledExecutor();

public static void main(String[] args) {
    Runnable timerFrameRunnable = new Runnable() {

        @Override
        public void run() {
            if (inTimePeriond() == false) {
                shortTimeExecutor.shutdown();
            } else {
                if (shortTimeExecutor.isShutdown()) {
                    Runnable shortTimeRunnable = new Runnable() {

                        @Override
                        public void run() {
                            // do your stuff
                        }
                    };
                    shortTimeExecutor.scheduleAtFixedRate(shortTimeRunnable, 0, 500, TimeUnit.MILLISECONDS);
                }
            }
        }
    };
    timerFrameExecutor.scheduleAtFixedRate(timerFrameRunnable, 0, 1, TimeUnit.MINUTES);
}