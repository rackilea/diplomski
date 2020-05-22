import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

    public class ExecutorServiceWithCallable extends ThreadPoolExecutor {

        public ExecutorServiceWithCallable(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        public <T> FutureWithCallable submit(Callable<T> callable) {
            Future<T> future = super.submit(callable);
            return new FutureWithCallable<T>(future, callable);
        }

    }