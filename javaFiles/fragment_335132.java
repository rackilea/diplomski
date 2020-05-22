public class PhoneStateReceiver extends BroadcastReceiver {
 @Override
 public void onReceive(Context context, Intent intent) {

try {
    System.out.println("Receiver start");
    String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
    String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);


    if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
        Toast.makeText(context, "Call Idle State"+incomingNumber, Toast.LENGTH_SHORT).show();


            DeleteCallLogByNumber("97********", context);
            Toast.makeText(context, "Log deleted", Toast.LENGTH_SHORT).show();


    }
} catch (Exception e) {
    e.printStackTrace();
  }

}

public void DeleteCallLogByNumber(String number, Context context) {
String queryString = "NUMBER='" + number+"'";


if (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {

    return;
}
context.getContentResolver().delete(CallLog.Calls.CONTENT_URI, queryString, null);
 }
}