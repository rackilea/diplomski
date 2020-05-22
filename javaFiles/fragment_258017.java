public class TimerTest {
    private static final int SPEED = 1000;

    public static void main(final String[] args) {
        new TimerTest().testTimers();
    }

    private void testTimers() {
        testSwingTimer();
        System.out.println("------");
        testUtilTimer();
    }

    private void testSwingTimer() {
        final javax.swing.Timer t =
            new javax.swing.Timer(SPEED, e -> System.out.println("testSwingTimer: "
                                                                 + new Date()));
        t.start();
        delay(4000);
    }

    private void testUtilTimer() {
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("testUtilTimer: " + new Date());
            }
        };
        final java.util.Timer timer = new java.util.Timer(true);
        timer.schedule(task, 0, SPEED);
        delay(2000);
    }

    private void delay(final int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}