Timer t = new Timer(true);
t.schedule(new TimerTask() {
        @Override
        public void run() {
            updateTime();
        }
    }, new Date() , 1000l);