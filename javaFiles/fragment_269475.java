package YourPackageName;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoStart extends BroadcastReceiver
{   
    @Override
    public void onReceive(Context context, Intent intent)
    {   
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            // Your Code
            Toast.makeText(context, "Started !!!", Toast.LENGTH_LONG).show();           
        }
    }
}