private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

public void beepForAnHour()
{
    scheduler.scheduleWithFixedDelay(new ThreadMaker(), 1L, 1L, TimeUnit.SECONDS);
}

private static class ThreadMaker implements Runnable
{
    @Override
    public void run() {
        Thread realThread = new Thread(new ExampleThread());
        realThread.start();
    }
}
private static class ExampleThread implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("1:"+System.currentTimeMillis());

        try
        {
            Thread.sleep(5000L);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("2:"+System.currentTimeMillis());
    }
}