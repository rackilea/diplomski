import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestClass {
static ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
static boolean shutdown = false;


public static void main(String[] args) throws Exception {
     new ShutdownChecker(30);
     Thread.sleep(90_000);
     shutdown = true;
}

private static class ShutdownChecker implements Runnable
{
    private final ScheduledFuture<?> future;

    public ShutdownChecker(int time)
    {
        future = TestClass.exec.scheduleAtFixedRate(this, 0, num, TimeUnit.SECONDS);
    }

    public void run()
    {
        if(TestClass.shutdown)
        {
            future.cancel();
            System.out.println("not running");
            return;
        }

        System.out.println("running");
    }
}

}