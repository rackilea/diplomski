public class ThreadDemonstration
{
private String str = null;
    private final Object monitor = new Object();

Thread stringCreator = new Thread(new Runnable()
{
    public void run()
    {           
        synchronized(monitor)
        {               
            str = "I have text";
            monitor.notify();            
        }
    }
});

private Thread stringUser = new Thread(new Runnable()
{
    public void run()
    {
        synchronized(monitor)
        {
            while(str == null) //changed from if to while. This allows you to wait again if the thread gets woken up by something other than the appropriate notify.
            {                   
                try {
                    System.out.println("str is null, I need help from stringCreator");
                    monitor.wait();
                    //removed print statement from here
                }
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
            System.out.println(str); //added print statement here. str is guaranteed to not be null here.
        }
    }
});