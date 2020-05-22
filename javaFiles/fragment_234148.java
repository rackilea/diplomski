b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           int initialDelay = 100; // start after 0.1 seconds
           int period = 100;        // repeat every 0.1 seconds
        {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
            public void run() {
                runTest();
            };
        timer.scheduleAtFixedRate(task, initialDelay, period);
        }
        {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
            public void run() {
                updateProgress();
            };
        timer.scheduleAtFixedRate(task, initialDelay, period);
        }
    }
    });

}