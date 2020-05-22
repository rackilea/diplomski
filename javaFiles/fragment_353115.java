Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            System.out.print("I would be called every 2 seconds");
        }
    }, 0, 2000);