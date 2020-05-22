static class WaitingRejectionHandler implements RejectedExecutionHandler {
  public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    try {
      executor.getQueue().put(r);// block until capacity available
    } catch(InterruptedException ex) {
      throw new RejectedExecutionException(ex);
    }
  }
}
public static void main(String[] args)
{
  final int nCPU=Runtime.getRuntime().availableProcessors();
  final int maxPendingJobs=100;
  ExecutorService executorService=new ThreadPoolExecutor(nCPU, nCPU, 1, TimeUnit.MINUTES,
    new ArrayBlockingQueue<Runnable>(maxPendingJobs), new WaitingRejectionHandler());

  // start flooding the `executorService` with jobs here