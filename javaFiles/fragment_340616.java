public class LoggerTest implements Runnable
{
    static int inc=0;
    private static ThreadLocal<Logger> log=new ThreadLocal<Logger>();
    FileHandler fh;
    int str;
    public LoggerTest(int counter,String instanceName) throws SecurityException, IOException
    {
        str=counter;
        fh=new FileHandler(instanceName+".log");
        fh.setFormatter(new SimpleFormatter());
    }
    public static void main(String[] args) throws SecurityException, IOException
    {
        Thread t1=new Thread(new LoggerTest(1, "file"+1),"Thread1");
        Thread t2=new Thread(new LoggerTest(2, "file"+2),"Thread2");
        Thread t3=new Thread(new LoggerTest(3, "file"+3),"Thread3");
        Thread t4=new Thread(new LoggerTest(4, "file"+4),"Thread4");
        t1.start();t2.start();t3.start();t4.start();
    }
    void meth()
    {
        log.set(Logger.getLogger("Logging"+str));
        log.get().addHandler(fh);
        for (int i = 0; i < 5; i++)
        {
            log.get().info(log.get().getName()+" Message"+i+" "+RandomStringUtils.random(str));
            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run()
    {
        this.meth();
    }
}