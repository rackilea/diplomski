import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {

    private final static int MAX_NUMBER_OF_THREADS = 2;
    private final static int EXECUTION_SCHEDULE_PERIOD_IN_SECONDS = 5;
    private final static int INITAL_DELAY_IN_SECONDS = 0;

    // set maximum number of threads as per your requirement/performance tuning, for testing set it to "2" and to have better feel.
    private final static ScheduledThreadPoolExecutor SCHEDULED_THREAD_POOL_EXECUTOR = new ScheduledThreadPoolExecutor(MAX_NUMBER_OF_THREADS);

    public static void main(String[] args) {
        scheduleTask(new MyRunnableTask("google1.com", 80)); // if you want more fields to set then either use constructor or have setter methods.
        scheduleTask(new MyRunnableTask("google2.com", 80)); // if you want more fields to set then either use constructor or have setter methods.
        scheduleTask(new MyRunnableTask("google3.com", 80)); // if you want more fields to set then either use constructor or have setter methods.
        scheduleTask(new MyRunnableTask("google4.com", 80)); // if you want more fields to set then either use constructor or have setter methods.
    }

    private static void scheduleTask(Runnable runnable) {
        SCHEDULED_THREAD_POOL_EXECUTOR.scheduleAtFixedRate(runnable, INITAL_DELAY_IN_SECONDS, EXECUTION_SCHEDULE_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    }
}