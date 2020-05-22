import java.util.Timer;
import java.util.TimerTask;

public class WaitTest extends TimerTask
{
    private Timer t;

    public WaitTest()
    {
        // TODO Auto-generated constructor stub
        this.t = new Timer(true);
    }
    public void run()
    {
        System.out.println("Player folded");

    }

    public void test()
    {
        // Schedule task for 5 sec time unless the 
        // controller cancels
        t.schedule(this, 5000);

    }

    public Timer getT()
    {
        return t;
    }

}