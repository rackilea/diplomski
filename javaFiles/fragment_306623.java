// Cancel the previous timer which will also abort the scheduled task
timer.cancel();
// Create a new timer
timer = new Timer();
// Re-schedule the task
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        // Launch my query here
    }
}, 200L);