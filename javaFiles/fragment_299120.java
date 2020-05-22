Semaphore semaphore = new Semaphore(MAX);
// ... much later ...
public void addTask(Runnable task)
{
  if (semaphore.tryAcquire())
    task.run();
  else
    queue.add(task);
}

public void afterTaskComplete(Runnable task)
{
  semaphore.release();
}