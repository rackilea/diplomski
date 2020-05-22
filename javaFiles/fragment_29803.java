final Timer t = new Timer();
t.schedule(new TimerTask() {
    @Override
    public void run() {
        // Do work.
        if (!timing) {
            t.cancel();
        }
    }
});