public FixedRateConsumer implements Runnable
{
    private final object _lock = new object();
    // *** use a concurrent collection here ***
    private Queue<Runnable> _workQueue; 

    public FixedRateConsumer()
    {
        _workQueue = new Queue<Runnable>();
    }

    public scheduleTask(Runnable task)
    {
        synchronized(_lock)
        {
            _workQueue.put(task); 
        }
    }

    public void run()
    {
        synchronized(_lock)
        {
            while(_workQueue.poll()!=null)
            {
                _workQueue.take().run();
            }
        }
    }
}