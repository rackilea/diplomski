private final Runnable r = new Runnable() {
    @Override
    public void run() {
        // ...
    }
};

private final ScheduledExecutorService ses = 
    Executors.newSingleThreadScheduledExecutor();
ScheduledFuture<?> sf = ses.scheduleAtFixedRate(r, 0, 10, TimeUnit.SECONDS);

// change to 5 sec: cancel and reschedule
sf.cancel();
sf = ses.scheduleAtFixedRate(r, 0, 5, TimeUnit.SECONDS);