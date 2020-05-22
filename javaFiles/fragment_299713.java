if (state == SHUTDOWN)  // Help drain queue
    r = workQueue.poll();
else if (poolSize > corePoolSize || allowCoreThreadTimeOut)
    r = workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS);
else
    r = workQueue.take();
if (r != null)
    return r;
if (workerCanExit()) {
    if (runState >= SHUTDOWN) // Wake up others
        interruptIdleWorkers();
    return null;
}