//product qr code mode
public void scanQR(View v, Context ctx) {
    try {
        //start the scanning activity from the com.google.zxing.client.android.SCAN intent
        Intent intent = new Intent(ACTION_SCAN);
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        ((Activity) ctx).startActivityForResult(intent, 0);
    } catch (ActivityNotFoundException anfe) {
        //on catch, show the download dialog
    }
}