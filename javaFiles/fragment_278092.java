private void register() {
_scheduler.scheduleWithFixedDelay(new Runnable() { 
    @Override public void run() { 
        System.out.println("!doing stuff...");
        }
    }, 1, 1, TimeUnit.SECONDS);