import java.util.concurrent.atomic.AtomicInteger;

public class SecondCounter implements Runnable
{
private volatile AtomicInteger counter;
private boolean active;
private boolean printed;
private Thread thread;

public SecondCounter()
{
    counter = new AtomicInteger(0);
    active = true;
    thread = new Thread(this);
    thread.start();
}



public void run()
{

    while(active)
    {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {ex.printStackTrace();}

        synchronized(this)
        {
            System.out.print(counter.incrementAndGet()+" ");    
            printed = false;
            try{
                this.notify();
                this.wait();
            } catch(InterruptedException ex) {ex.printStackTrace();}
        }
    }
}

public synchronized void messagePrinter(final int x)
{
    Runnable mp = new Runnable()
    {
        public void run()
        {
            while(active)
            {
                synchronized(SecondCounter.this)
                {
                    try {
                        while(counter.get()%x != 0 || counter.get() == 0 )
                        {
                            SecondCounter.this.notify();
                            SecondCounter.this.wait();
                        }
                        if(!printed)
                        {
                            System.out.println("\n"+x+" second message");
                            printed = true;
                        }
                        SecondCounter.this.notify();
                        SecondCounter.this.wait();
                    } catch(InterruptedException ex) {ex.printStackTrace();}
                }
            }
        }
    };
    new Thread(mp).start();
}