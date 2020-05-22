import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Mechalikh on 21/12/2014.
 */
public class BootCompleted extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
if(intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)){
    Intent serviceIntent= new Intent(context,MyService.class);
    context.startService(serviceIntent);
}
    }

}