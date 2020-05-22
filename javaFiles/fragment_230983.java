import java.util.concurrent.*;

public class PostProcExecutor extends ThreadPoolExecutor {

  // adjust the constructor to your desired threading policy
  public PostProcExecutor(int corePoolSize, int maximumPoolSize,
      long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }

  @Override
  protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
    return new FutureTask<T>(callable) {
      @Override
      protected void done()
      {
        if(!isCancelled()) try {
          processResult(get());
        } catch(InterruptedException ex) {
          throw new AssertionError("on complete task", ex);
        } catch(ExecutionException ex) {
          // no result available
        }
      }
    };
  }

  protected void processResult(Object o)
  {
    System.out.println("Result "+o);// do your post-processing here
  }
}