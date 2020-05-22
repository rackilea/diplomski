import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScheduledMultiThread
{
    public static void main(String[] args)
    {
        Timer timer = new Timer();
        long period = 1000;

        DataCollector dc = new DataCollector();
        timer.schedule(dc, 0, period);


    }
}

class DataCollector extends TimerTask
{
    private ExecutorService executorService;

    @Override
    public void run()
    {
        int variables = readFromPlc();
        if (executorService == null)
        {
            executorService = Executors.newFixedThreadPool(variables);
        }

        List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
        for (int i=0; i<variables; i++)
        {
            Runnable task = createTaskForVariable(i);
            tasks.add(Executors.callable(task));
        }
        try
        {
            executorService.invokeAll(tasks);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    private Runnable createTaskForVariable(final int variable)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                executeTaskFor(variable);
            }
        };
        return runnable;
    }


    // Dummy implementations
    private void executeTaskFor(int variable)
    {
        System.out.println("Working for variable "+variable);
        try
        {
            Thread.sleep((long)(200+Math.random()*200));
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("Working for variable "+variable+" DONE");
    }

    private int readFromPlc()
    {
        return 8;
    }


}