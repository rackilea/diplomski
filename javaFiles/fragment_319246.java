public class SmsReceiver extends BroadcastReceiver {

private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";


@Override
public void onReceive(Context context, Intent intent) {
    // Log.i(TAG, "Intent received: " + intent.getAction());

    if (intent.getAction().equals(SMS_RECEIVED)) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            final SmsMessage[] messages = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            if (messages.length > -1) {                 

                  String str=messages[0].getMessageBody();

                  if(check for the text in the string str)
                  {                      
                      abortBroadcast();//stops msg from reaching inbox                   
                  } 

              }
          }
      }
  }
}