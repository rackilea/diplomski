public class Main {
ScheduledExecutorService _poolInstance;
ScheduledFuture<?> _future;
public Main(ScheduledExecutorService p)
{
    _poolInstance = p;
    _future = _poolInstance.scheduleWithFixedDelay(new ResourceRefreshRunner(this), 1, 1, TimeUnit.SECONDS);
}  ...