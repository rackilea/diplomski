import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {
    ListeningExecutorService listeningExecutorService;
    ScheduledExecutorService scheduledExecutorService;
    Runnable task;

    public Worker(ListeningExecutorService listeningExecutorService, ScheduledExecutorService scheduledExecutorService, Runnable task) {
        this.listeningExecutorService = listeningExecutorService;
        this.scheduledExecutorService = scheduledExecutorService;
        this.task = task;
    }

    @Override
    public void run() {
        ListenableFuture future = listeningExecutorService.submit(task);
        Futures.withTimeout(future, 3, TimeUnit.SECONDS, scheduledExecutorService);
    }

    public static void main(String[] args) {
        ListeningExecutorService listeningExecutorService = MoreExecutors
            .listeningDecorator(Executors.newCachedThreadPool());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        Worker worker = new Worker(listeningExecutorService, scheduledExecutorService, new Runnable() {
            @Override
            public void run() {
                System.out.println("Now begin: " + new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Now end: " + new Date());
            }
        });
        scheduledExecutorService.scheduleAtFixedRate(worker, 0, 10, TimeUnit.SECONDS);
    }
}