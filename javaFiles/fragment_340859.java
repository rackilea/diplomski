import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UserPresentBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent intent) {

        /*Sent when the user is present after 
         * device wakes up (e.g when the keyguard is gone)
         * */
        if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){

        }
    }

}