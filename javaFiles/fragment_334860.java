Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        // Update your counter/notification each second
    }

}, 0, 1000);