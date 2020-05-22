// prefer this constructor with zero core threads for a shared pool,
// to avoid blocking JVM exit
static final ScheduledExecutorService SCHEDULER = new ScheduledThreadPoolExecutor(0);
static Executor delayedExecutor(long delay, TimeUnit unit)
{
  return delayedExecutor(delay, unit, ForkJoinPool.commonPool());
}
static Executor delayedExecutor(long delay, TimeUnit unit, Executor executor)
{
  return r -> SCHEDULER.schedule(() -> executor.execute(r), delay, unit);
}