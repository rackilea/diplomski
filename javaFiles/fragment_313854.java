private ScheduledExecutorService scheduledExecutorService;
private ScheduledFuture<?> futureTask;
private Runnable myTask;

@Override
public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);

    // Your executor, you should instanciate it once for all
    scheduledExecutorService = Executors.newScheduledThreadPool(5);

    // Since your task won't change during runtime, you can instanciate it too once for all
    myTask = new Runnable()
    {
        @Override
        public void run()
        {
            // Your code to run periodically
        }
    };
}

/**
 * This method will reschedule "myTask" with the new param time
 */
public void changeReadInterval(long time)
{
    if(time > 0)
    {       
        if (futureTask != null)
        {
            futureTask.cancel(true);
        }

        futureTask = scheduledExecutorService.scheduleAtFixedRate(myTask, 0, time, TimeUnit.SECONDS);
    }
}