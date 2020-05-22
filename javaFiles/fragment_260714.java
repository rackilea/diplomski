private Timer timer = new Timer();
private int standby_zaehler = 0;
private Random r = new Random();

public void scheduleNextTimer() {
    // reset our countdown
    standby_zaehler = 0;
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            // 1 second passed, remove it to the countdown
            --standby_zaehler;
            // we are finished counting down. get a new max seconds
            if(standby_zaehler < 0) {
                standby_zaehler = r.nextInt(60);
            }
        }
    }, 1000, 1000);
}