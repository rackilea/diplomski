YourThread thread = new YourThread(yourActivity);
thread.start();

//YourThread
public class YourThread extends Thread
{
    Tab3Activity activity;
    public YourThread(Tab3Activity activity)
    {
       Tab3Activity.activity = activity;
    }

...
    activity.setText(index,"string here");
...
}