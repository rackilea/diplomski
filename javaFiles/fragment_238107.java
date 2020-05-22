import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SingleThreadAccess {
    public static final SingleThreadAccess INSTANCE = new SingleThreadAccess();

    private ExecutorService executor;

    // to be called by ServletContextListener.contextInitialized()
    public void init() {
        executor = Executors.newSingleThreadExecutor();
    }

    // to be called by ServletContextListener.contextDestroyed()
    public void shutdown() {
        executor.shutdown();
        try {
            executor.awaitTermination(2L,TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
        }
        executor.shutdownNow();
    }

    public int readInt(int min, int max) throws QuantisException, InterruptedException {
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws QuantisException {
                return quantisReadScaledInt(deviceType.getType(), deviceNumber, min, max);
            }
        };
        Future<Integer> future = executor.submit(task);
        try {
            future.get();
        }
        catch (ExecutionException e) {
            unwrap(e);
        }
    }

    private void unwrap(ExecutionException e) throws QuantisException {
        Throwable t = e.getCause();
        if (t instanceof QuantisException) {
            throw (QuantisException) t;
        }
        throw new RuntimeException(e);
    }
}