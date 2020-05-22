import java.util.Random;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Main
{
    private static int CALCULATION_THRESHOLD = 2000;

    private static Stack<Object> results = new Stack<Object>();

    private static Object resultTrigger = new Object();

    public static void main(String[] args)
    {
        Timer calculationTimer = new Timer(true);
        calculationTimer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                Thread calculationThread = new Thread() {
                    public void run() {
                        Object result = performCalculation();
                        results.push(result);
                        synchronized(resultTrigger) {
                            resultTrigger.notifyAll();
                        }       
                    }
                };
                calculationThread.start();
            }
        }, CALCULATION_THRESHOLD, CALCULATION_THRESHOLD);

        synchronized(resultTrigger) {
            if (results.isEmpty()) {
                // This is bad as it will never end if you don't
                // get a result, add a timeout here. 
                try { resultTrigger.wait(); }
                catch (InterruptedException ex) {}
            }
        }

        // Get the next result
        Object result = results.pop();

        System.out.println ("Latest result is : " + result);

        // Do something with the remaining results or throw 
        // them away
        results.clear();
    }

    private static AtomicInteger counter = new AtomicInteger();

    // This is the method we are assuming can't be
    // changed to check for a stop flag.
    public static Object performCalculation()
    {
        int calcID = counter.addAndGet(1);
        System.out.println ("Calculation " + calcID + " is running.");
        Random randomGenerator = new Random();
        int sleep = randomGenerator.nextInt(10000);
        // Ensure we sleep for at least 2 seconds
        try { Thread.sleep(sleep + 2000);   }
        catch (InterruptedException ex) {}
        return String.valueOf(counter.get());
    }
}