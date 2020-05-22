Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        receiveChatMessage();
    }
}, 0, 1000);