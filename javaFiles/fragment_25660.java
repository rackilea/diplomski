public void doTimerJob() {
    final Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            try {
                throw new IOException("file not found");
            } catch (IOException e) {
                timer.cancel();
                throw new RuntimeException(e);
            }
        }
    }, new Date(), 2000);
}