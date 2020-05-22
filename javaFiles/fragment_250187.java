import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {

    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(final String[] args) throws InterruptedException {
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("executed");
            }
        }, 0, 1, TimeUnit.SECONDS);


        Thread.sleep(10000);
        scheduler.shutdownNow();
    }

}