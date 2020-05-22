import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.joda.time.DateTime;
public class NewTimerDemo extends TimerTask
{ 
  static Timer timer  = new Timer();
  static String startTime = "12:28";
  static String endTime = "12:30";

@Override
public void run()
{
    System.out.println("Running your Task");

    DateTime dt = new DateTime().withTime(
            Integer.parseInt(endTime.split(":")[0]), 
            Integer.parseInt(endTime.split(":")[1]), 0, 0);
    if(!dt.isAfterNow())
    {
        System.out.println("Here to cancel");
        timer.cancel();
    }
}
 public static void main(String args[])
 {
    DateTime dt = new DateTime().withTime(
            Integer.parseInt(startTime.split(":")[0]), 
            Integer.parseInt(startTime.split(":")[1]), 0, 0);
    System.out.println(dt);
    Date date = dt.toDate();
    timer.schedule(new NewTimerDemo(), date, 5*1000);
 }
}