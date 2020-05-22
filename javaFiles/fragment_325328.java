// synchronous queue waits for someone to take() from the queue before returning
final BlockingQueue<Runnable> jobQueue = new SynchronousQueue<Runnable>();
...
// submit all of your threads who get jobs from your queue to run
executor.execute(new Runnable() {
    @Override
    public void run() {
         while (!Thread.currentThread.isInterrupted()) {
              try {
                  Runnable job = jobQueue.take();
                  job.run();
              } catch (InterruptedException ie) {
                  // always recommended
                  Thread.currentThread().interrupt();
                  return;
              }
         }
    }
});
...
// now we can try to add a job into the queue but if it is full, offer may timeout
if (!queue.offer(new Runnable() { ... }, 2000, TimeUnit.SECONDS)) {
    // timed out
}