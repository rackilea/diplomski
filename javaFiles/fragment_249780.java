import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class FutureWithCallable<T> implements Future<T> {
    private final Callable<T> callable;
    private final Future<T> wrapped;

    public FutureWithCallable(Future<T> wrapped, Callable<T> callable) {
        this.callable = callable;
        this.wrapped = wrapped;
    }

    public Callable<T> getCallable() {
        return callable;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return wrapped.cancel(mayInterruptIfRunning);
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        return wrapped.get();
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException,
            ExecutionException, TimeoutException {
        return wrapped.get(timeout, unit);
    }

    @Override
    public boolean isCancelled() {
        return wrapped.isCancelled();
    }

    @Override
    public boolean isDone() {
        return wrapped.isDone();
    }
}