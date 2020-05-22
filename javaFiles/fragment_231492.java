import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceImplementationExample {
    private final static int MAX_NUMBER_OF_THREADS = Integer.MAX_VALUE;

    // set maximum number of threads as per your requirement/performance tuning, for testing set it to "2" and to have better feel.
    private final static ExecutorService executorService = Executors.newFixedThreadPool(MAX_NUMBER_OF_THREADS);


    public static void main(String[] args) {
        System.out.println("### Starting.");

        new Thread(){
            @Override
            public void run() {
                scheduleTask(new MyRunnableTask());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                scheduleTask(new MyRunnableTask());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                scheduleTask(new MyRunnableTask());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                scheduleTask(new MyRunnableTask());
            }
        }.start();

        System.out.println("### Completed.");
    }

    private static void scheduleTask(Runnable runnable) {
        executorService.execute(runnable);
    }

}