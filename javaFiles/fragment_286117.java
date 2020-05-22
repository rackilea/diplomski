import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.telephony.gsm.SmsManager;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver
{
    public void onReceive(Context context, Intent intent)
    {
        Bundle myBundle = intent.getExtras();
        SmsMessage [] messages = null;
        String from= "";
        String body="";
        boolean inSIM=false;

        if (myBundle != null)
        {
            Object [] pdus = (Object[]) myBundle.get("pdus");
            messages = new SmsMessage[pdus.length];

            for (int i = 0; i < messages.length; i++)
            {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                from = ""+messages[i].getOriginatingAddress();
                body = ""+messages[i].getMessageBody();
                inSIM = (messages[i].getIndexOnSim() != -1);
                if (inSIM)
                {
                    int status = messages[i].getStatusOnSim();
                    if (status == SmsManager.STATUS_ON_SIM_UNREAD)
                    {
                       Toast.makeText(context, "Message Unread on SIM: "+from+": "+body, Toast.LENGTH_SHORT).show();
                    }
                }                
            }            
        }
    }
}