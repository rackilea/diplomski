public class MutableFuture<T> implements Future<T>
{
  private final CountDownLatch done = new CountDownLatch(1);
  private T value;
  private Throwable throwable;

  public synchronized boolean isDone()
  {
    return done.getCount() == 0;
  }

  public synchronized T get(long timeout, TimeUnit unit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    if (!done.await(timeout, unit))
      throw new TimeoutException();
    if (throwable != null)
      throw new ExecutionException(throwable);
    return value;
  }

  // remaining methods left as exercise to the reader :)
}