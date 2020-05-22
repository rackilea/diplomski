public class MyTask implements Runnable
{
    @Override
    public void run()
    {
        ...
    }
}

ExecutorService s = Executors.newSingleThreadExecutor();
Future<?> submit = s.submit(new Task());