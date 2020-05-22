Timer timer = new Timer();
TimerTask task = new TimerTask() {
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
    }
};
timer.scheduleAtFixedRate(task, 0, 1000);