Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            ...
        }
    }, 0, 1000);