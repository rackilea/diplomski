public class SendSms extends Activity {

private Activity mActivity;
private int requestPerm;

public SendSms(Activity mActivity) {
    this.mActivity = mActivity;

}

private void checkPermissionSms() {
    if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, requestPerm);
        //If we don't have the permission, request it here
    }
  }
}