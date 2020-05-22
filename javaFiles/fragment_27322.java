public class MyTask implements Runnable
{
    public void run() 
    {
        psServiceWrapper.processHRFeed();
    }
}