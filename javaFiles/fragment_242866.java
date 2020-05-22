public class SmsBroadcastReceiver extends BroadcastReceiver {
 String address;
public static final String SMS_BUNDLE = "pdus";

public void onReceive(Context context, Intent intent) {
    Bundle intentExtras = intent.getExtras();

        if (intentExtras != null) {
        Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
        String smsMessageStr = "";
        for (int i = 0; i < sms.length; ++i) {
            String format = intentExtras.getString("format");
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i], format);

            String smsBody = smsMessage.getMessageBody().toString();
            address = smsMessage.getOriginatingAddress();


             smsMessageStr += "SMS From: " + address + "\n";
             smsMessageStr += smsBody + "\n";



        }
       if(address =="7911127456"){
        MainActivity inst = MainActivity.instance();
        inst.updateInbox(smsMessageStr);
      }
    }
}
}