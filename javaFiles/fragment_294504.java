private Timer timer;
private final int DELAY = 100;
private final int DURATION = 10_000;
private final int TOTAL_TICKS = DURATION / DELAY;
private int tickCounter = 0;

public void timerExample() {
    timer = new Timer(DELAY, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (++tickCounter == TOTAL_TICKS) {
                System.out.println("Done");
                timer.stop();
            } else {
                System.out.println("Tick");
            }
        }
    });
    timer.start();
}