import java.util.Timer;
import java.util.TimerTask;

/** @see http://stackoverflow.com/questions/4503829 */
public class TimerTest {

    private static final int MAX = 8;

    public static void main(String[] args) {
        final Timer cpu = new Timer();
        cpu.scheduleAtFixedRate(new TimerTask() {

            private int count;

            @Override
            public void run() {
                count++;
                System.out.println("Count: " + count);
                if (count == MAX) {
                    cpu.cancel();
                }
            }
        }, 100, 1000);
    }
}