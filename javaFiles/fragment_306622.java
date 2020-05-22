Timer timer = new Timer();
// Schedule my task to be executed in 200 milliseconds
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        // Launch my query here
    }
}, 200L);