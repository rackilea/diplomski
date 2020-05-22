import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolApp {
    public static void main(String[] args) {
        long execTime = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Task());
        }
        System.out.println("threads submitted and waiting execution");

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
        }
        execTime = System.currentTimeMillis() - execTime;
        System.out.format("%d threads finished execution \n",Task.getCount());
        System.out.println("thread time : " + Task.getTime());
        System.out.println("main time : " + execTime);
    }
}

class Task implements Runnable {

    private static long totalTime;
    private static int count;
    public static long getTime(){
        synchronized(Task.class){
            return totalTime;
        }
    }
    public static int getCount(){ return count; }

    public void run() {
        count++;
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
            synchronized(Task.class){
                totalTime += System.currentTimeMillis() - startTime;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}