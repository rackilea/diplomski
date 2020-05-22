Timer t = new Timer();
    t.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            System.out.println("a");
        }
    }, 0, 100);
    t.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            System.out.println("b");
        }
    }, 0, 100);