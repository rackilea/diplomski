public class TaskWrapper implements Runnable
{
    private Runnable task;
    private int maxResubmits;
    private ThreadPoolExecutor executor;
    private CountDownLatch latch;

    public TaskWrapper(Runnable task, int maxResubmits, ThreadPoolExecutor executor, CountDownLatch latch) {
        this.task=task;
        this.maxResubmits=maxResubmits;
        this.executor=executor;
        this.latch=latch;
        executor.submit(this);
    }

    public void run() {
        try {
            task.run();
            latch.countdoun();
        }
        catch(Exception e) {
            maxResubmits--;
            if(maxResubmits>0)
                executor.submit(this);
            else
            {
                latch.countdoun();
                executor.shutdownNow()
            }                
        }
    }
}