import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public abstract class MyFutureClass<V> implements Callable<V> {

private final FutureTask<V> futureTask;

public MyFutureClass() {
    futureTask = new FutureTask<V>(this);
}

@Override
public V call() throws Exception {
    return myCall();
}

protected abstract V myCall();

public FutureTask<V> getFutureTask() {
    return futureTask;
}
}