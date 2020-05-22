import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class TimedExecutor extends ThreadPoolExecutor {
    private ThreadLocal<Long> startTime = new ThreadLocal<>();
    private AtomicLong totalExecutionTime = new AtomicLong(0);

    public TimedExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        startTime.set(System.currentTimeMillis());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        long taskExecutionTime = System.currentTimeMillis() - startTime.get();
        totalExecutionTime.addAndGet(taskExecutionTime);
    }

    public long totalExecutionTime() {
        return totalExecutionTime.get();
    }

    public static TimedExecutor newFixedThreadPool(int noOfThreads) {
        int corePoolSize = noOfThreads;
        int maximumPoolSize = noOfThreads;
        return new TimedExecutor(corePoolSize, maximumPoolSize, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
}