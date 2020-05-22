List<Runnable> tasks;
int maxResubmits;

CountDownLatch latch=new CountDownLatch(tasks.size());

tasks.forEach(task->new TaskWrapper(task,maxResubmits,executor,latch));

latch.await();

if(!executor.isShutdown())
    executor.shutdown();