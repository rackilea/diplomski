import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

public class MyNewService extends IntentService 
{

    public MyNewService()
    {
      super("Service Name");    
    }

    @Override
    protected void onHandleIntent(Intent intent) 
    {
       //Do some background task . 
          int progressValue = 20 ;

       //Send broadcast like this
        Intent broadcast = new Intent();
       // name should be same as specified in your activity class onResume method
        broadcast.setAction("BROADCAST_UNIQUE_NAME");
       //send extra data with your broadcast   
       broadcast.putExtra("progressValue",progressValue);
       //send it now
       sendBroadcast(broadcast); 
    }
}