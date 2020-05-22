ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
exec.scheduleWithFixedDelay(new Runnable() {
        public void run() {
            // TODO: do something
        }
    }, 
    0, // no wait and start the 1st one
    5, // delay 5 seconds and do the next one
    TimeUnit.SECONDS);