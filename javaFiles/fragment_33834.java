import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    private static Timer timer;

    public static void main(String[] args) {

        timer = new Timer();
        timer.scheduleAtFixedRate(new TickTask(), 0, 1000);

    }

    public static class TickTask extends TimerTask {

        private boolean started = false;
        private long startTime = 0;

        @Override
        public void run() {
            if (!started) {
                started = true;
                startTime = System.currentTimeMillis();
            } else {
                long dif = System.currentTimeMillis() - startTime;
                long seconds = dif / 1000;
                System.out.println(seconds);
                if (seconds >= 90) {
                    timer.cancel();
                }
            }
        }

    }

}