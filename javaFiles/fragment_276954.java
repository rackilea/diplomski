public Timer scheduleCleanup(long interval) {
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            doCleanup();
        }
    };
    Timer timer = new Timer(getClass().getName(), true);
    timer.scheduleAtFixedRate(task, 0L, interval);
    return timer;
}