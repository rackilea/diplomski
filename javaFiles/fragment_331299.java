public class CustomBroadcastReceiver extends BroadcastReceiver {

private static final String TAG = "CustomBroadcastReceiver";

@Override
public void onReceive(Context context, Intent intent) {
    Log.v(TAG, "inside");
TelephonyManager telephony =     (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    CustomPhoneStateListener customPhoneListener = new CustomPhoneStateListener();

telephony.listen(customPhoneListener, PhoneStateListener.LISTEN_CALL_STATE);


Bundle bundle = intent.getExtras();
String phoneNr= bundle.getString("incoming_number");
    Log.v(TAG, "phoneNr: "+phoneNr);

}