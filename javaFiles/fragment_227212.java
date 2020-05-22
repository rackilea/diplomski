TimerTask task = new TimerTask() {
        @Override
        public void run() {
            purge(dir, ttl);
        }
    };
    TIMER.schedule(task, period, period);