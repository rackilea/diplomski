import java.util.Timer;
import java.util.TimerTask;

public class TimerTest
{
    private Timer timer;

    public void cancelTimer()
    {
        this.timer.cancel();
        System.out.println("Canceled timer!");
    }

    public void startTimer()
    {
        // once a timertask is canceled, you can not restart it
        // because the thread is deleted. So we need to create a 
        // new object of a timer and a timertask.
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println("Hello there!");
            }
        };
        this.timer = new Timer();
        System.out.println("Starting timer ...");
        int period = 1000;
        this.timer.schedule(timerTask, 0, period);
    }

    public static void main(String[] args) throws InterruptedException
    {
        TimerTest tt = new TimerTest();
        tt.startTimer();
        Thread.sleep(5000);
        tt.cancelTimer(); // you can call this method, as soon as u have a correct answer
        Thread.sleep(1000);
        tt.startTimer(); // you can restart your timer as demanded
        Thread.sleep(5000);
        tt.cancelTimer(); // and cancel it again
    }
}