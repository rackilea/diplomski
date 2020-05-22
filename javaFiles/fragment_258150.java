@Override
public <T> Future<T> submit(Callable<T> callable) {
    FutureTask<T> future = new FutureTask(callable);
    queue.put(future);
    return future;
}