import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MeasureExecutorTime {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); // any executor - your choice
        LinkedList<Runnable> runnables = new LinkedList<>(); // place your Runnables here, to minimize influence of initialization.

        long startTime = System.currentTimeMillis();
        for (Runnable command : runnables) {
            executorService.execute(command);
        }
        executorService.shutdownNow();
        // next line will block till all tasks finishes
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        long totalExecutionTime = System.currentTimeMillis() - startTime;
    }
}