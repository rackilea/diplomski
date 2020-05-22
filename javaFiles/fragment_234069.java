public static final int REQUEST_CODE = 0x0ba7c0de;
private static final String SCAN_INTENT = "com.google.zxing.client.android.SCAN";

public void scan() {
    Intent intentScan = new Intent(SCAN_INTENT);
    intentScan.addCategory(Intent.CATEGORY_DEFAULT);
    this.startActivityForResult(intentScan, REQUEST_CODE);
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    if (requestCode == REQUEST_CODE) {
        if (resultCode == Activity.RESULT_OK) {
            String barcode = intent.getStringExtra("SCAN_RESULT");
            String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
            //Do whatever you need with the barcode here
        } else if (resultCode == Activity.RESULT_CANCELED) {
            // handle a canceled scan
        } else {
            // throw an error or something
        }
    }
}