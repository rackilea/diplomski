final AtomicReference<ScheduledFuture> futureReference =
    new AtomicReference<ScheduledFuture>();
ScheduledFuture exec = executor.scheduleAtFixedRate(
    new Runnable() {
        int totalSends = 0;
        public void run() {
            //do stuff here
            if (++totalSends >= repetitions) {
                // we need to wait for the future to be initialized
                while (futureReference.get() == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread.().interrupt();
                    }
                }
                futureReference.get().cancel(true);
            }
        }
    },
    0, delay, TimeUnit.MILLISECONDS);
futureReference.set(exec);