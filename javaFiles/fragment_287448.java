ScheduledExecutorService sched = Executors.newScheduledThreadPool(1);  // single-threaded OK

final ScheduledFuture<?> future = sched.scheduleAtFixedRate( new Runnable() {
    public void run() {
        if (canDoStuffNow) {
            doStuffNow();
        }
        else {
            // Skip, wait another second
        }
    }
}, /* Delay for */ 0, /* Every */ 1, TimeUnit.SECONDS);