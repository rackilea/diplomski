ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(THREAD_POOL_SIZE);

// Evenly spread the execution of a set of tasks over a period of time
public void schedule(Set<Task> taskSet, long timePeriod, TimeUnit timeUnit) {
    if (taskSet.isEmpty()) return; // or indicate some failure ...
    long period = TimeUnit.MILLISECOND.convert(timePeriod, timeUnit);
    long delay = period/taskSet.size();
    long accumulativeDelay = 0;
    for (Task task:taskSet) {
        scheduledExecutor.schedule(task, accumulativeDelay, TimeUnit.MILLISECOND);
        accumulativeDelay += delay;
    }
}