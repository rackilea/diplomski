import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


//The task which you want to execute
class MyTimeTask extends TimerTask
{
    public void run()
    {
        System.out.println("DO some task");
    }

public static void main(String[] args) throws ParseException {

    //the Date and time at which you want to execute
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
    Date date = dateFormatter.parse("2018-05-23 12:43 am");
    Date date1 = dateFormatter.parse("2018-05-23 12:43 pm");
    ArrayList<Date> d=new ArrayList<>();
    d.add(date);
    d.add(date1);
    //Now create the time and schedule it
    Timer timer = new Timer();
    //Use this if you want to execute it once
   for(Date dd:d){
       timer.schedule(new MyTimeTask(),dd);
    }

    //Use this if you want to execute it repeatedly
    //int period = 10000;//10secs
    //timer.schedule(new MyTimeTask(), date, period );
 }
}