import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public interface Event
{
}

public interface Listener
{
    void handle(Event event);
}

public class Monitor
{
    private static final int CHECK_EVERY_SECONDS = 10;
    private static final int RECHECK_AFTER_IF_NOT_EXISTS_SECONDS = 30;

    private File file;
    private ScheduledExecutorService executor;
    private boolean active;
    private List<Listener> listeners;

    public Monitor(File file, ScheduledExecutorService executor)
    {
        super();
        this.file = file;
        this.executor = executor;
        listeners = new ArrayList<Listener>();
    }

    public synchronized void start()
    {
        if (active)
        {
            return;
        }
        active = true;
        executor.execute(new Runnable()
        {
            public void run()
            {
                synchronized (Monitor.this)
                {
                    if (!active)
                    {
                        System.out.println("not active");
                        return;
                    }
                }
                if (!file.exists())
                {
                    System.out.println("does not exist, rescheduled");
                    executor.schedule(this, RECHECK_AFTER_IF_NOT_EXISTS_SECONDS, TimeUnit.SECONDS);
                    return;
                }
                Event event = doStuff(file);
                System.out.println("generated " + event);
                updateListeners(event);
                System.out.println("updated listeners and rescheduled");
                executor.schedule(this, CHECK_EVERY_SECONDS, TimeUnit.SECONDS);
            }
        });
    }

    private Event doStuff(final File file)
    {
        return new Event()
        {
            public String toString()
            {
                return "event for " + file;
            }
        };
    }

    public synchronized void stop()
    {
        active = false;
    }

    public void addListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.add(listener);
        }
    }

    public void removeListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.remove(listener);
        }
    }

    private void updateListeners(Event event)
    {
        synchronized (listeners)
        {
            for (Listener listener : listeners)
            {
                listener.handle(event);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        File file = new File("test.png");
        Monitor monitor = new Monitor(file, executor);
        monitor.addListener(new Listener()
        {
            public void handle(Event event)
            {
                System.out.println("handling " + event);
            }
        });
        monitor.start();
        System.out.println("started...");
        System.in.read();       
        monitor.stop();
        System.out.println("done");
        executor.shutdown();
    }

}