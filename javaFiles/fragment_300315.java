@Override
public void onReceive(Context context, Intent intent)
{
Log.e("ABC", "** good");
if
(intent.getAction().equalsIgnoreCase
("android.provider.Telephony.SMS_RECEIVED))  


{
    Bundle bundle = intent.getExtras();
    if (bundle != null)``
    {
        Object[] pdus = (Object[]) bundle.get("pdus");
        final SmsMessage[] messages = new SmsMessage[pdus.length];
        for (int i = 0; i < pdus.length; i++)
        {
            messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
        }
        if (messages.length > -1)
        {
            Log.e("ABC",messages[0].getMessageBody().toString());
            latitudes = messages[0].getMessageBody().toString();
            Intent j = new Intent(context,MapsActivity.class);
            j.putExtra("messages",latitudes);
         context.startActivity(j);
        }
    }
}
}
}