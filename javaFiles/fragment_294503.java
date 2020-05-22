private Timer timer;
private final int DELAY = 100;
private final int DURATION = 10_000;
private long startTime;

public void timerExample() {
    timer = new Timer(DELAY, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (System.currentTimeMillis() >= startTime + DURATION) {
                System.out.println("Done");
                timer.stop();
            } else {
                System.out.println("Tick");
            }
        }
    });
    startTime = System.currentTimeMillis();
    timer.start();
}