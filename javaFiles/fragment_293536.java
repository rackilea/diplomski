public class MyJavaScriptInterface {

Context mContext;

MyJavaScriptInterface(Context c) {
    mContext = c;
}

@JavascriptInterface
public void showToast(String toast) {
    Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
}
@JavascriptInterface
public void sendsmss(String phoneNumber, String message) {

    SmsManager smsManager = SmsManager.getDefault();
    smsManager.sendTextMessage(phoneNumber, null, message, null, null);

 }
}