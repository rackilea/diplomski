final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
executor.schedule(() -> {
    // do work
    // reschedule
    executor.schedule(this, nextTime() - System.currentTimeMillis());
}, delay, TimeUnit.MILLISECONDS);