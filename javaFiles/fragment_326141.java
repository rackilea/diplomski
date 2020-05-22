ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
ses.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        sendScreenShot();
    }
}, 0, 1, TimeUnit.HOURS);