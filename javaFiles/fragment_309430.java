public class Deadlock {

    public static void main(String[] args) {

        Deadlock a = new Deadlock();
        String anotherLock = "";
        Threadslock first = new Threadslock(a,anotherLock);
        Threadslock second = new Threadslock(a,anotherLock);
        first.setName("First");
        second.setName("Second");
        first.start();
        second.start();

    }

}

class Threadslock extends Thread
{
    Deadlock lock ;
    String anotherLock;
    Threadslock(Deadlock lo, String anotherLock)
    {
        lock = lo;
        this.anotherLock = anotherLock;
    }
    public void run()
    {

        if(getName().equals("First"))
        {
            synchronized(lock)
            {
                System.out.println("First Thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized(anotherLock)
                {
                    try
                    {
                    Thread.sleep (2000);
                    }
                    catch(InterruptedException r)
                    {

                    }
                System.out.println("Next Step in First");
                }
            }
        }
        else
        {
            synchronized(anotherLock)
            {
                System.out.println("Second Thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                synchronized(lock)
                {
                    try{
                        Thread.sleep (2000);    
                    }
                    catch(Exception e)
                    {

                    }
                System.out.println("Next Step in Second");
                }
            }   
        }
    }
}