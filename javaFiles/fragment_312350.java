/**
     * Class Worker mainly maintains interrupt control state for
     * threads running tasks, along with other minor bookkeeping.
     * This class opportunistically extends AbstractQueuedSynchronizer
     * to simplify acquiring and releasing a lock surrounding each
     * task execution.  This protects against interrupts that are
     * intended to wake up a worker thread waiting for a task from
     * instead interrupting a task being run.  We implement a simple
     * non-reentrant mutual exclusion lock rather than use ReentrantLock
     * because we do not want worker tasks to be able to reacquire the
     * lock when they invoke pool control methods like setCorePoolSize.
     */
    private final class Worker
        extends AbstractQueuedSynchronizer
        implements Runnable
    {

      /** Delegates main run loop to outer runWorker  */
       public void run() {
            runWorker(this);
       }

    final void runWorker(Worker w) {
          Runnable task = w.firstTask;
          w.firstTask = null;
          boolean completedAbruptly = true;
    try {
        while (task != null || (task = getTask()) != null) {
            w.lock();
            clearInterruptsForTaskRun();
            try {
                beforeExecute(w.thread, task);
                Throwable thrown = null;
                try {
                    task.run();
                } catch (RuntimeException x) {
                    thrown = x; throw x;
                } catch (Error x) {
                    thrown = x; throw x;
                } catch (Throwable x) {
                    thrown = x; throw new Error(x);
                } finally {
                    afterExecute(task, thrown);
                }
            } finally {
                task = null;
                w.completedTasks++;
                w.unlock();
            }
        }
        completedAbruptly = false;
    } finally {
        processWorkerExit(w, completedAbruptly);
    }