public class ScannerActivity extends CaptureActivity {

/** The barcode format. */
String barcodeFormat;

/**
 * Called when the activity is first created.
 * 
 * @param savedInstanceState
 *            the saved instance state
 */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.barcode_scan);
}

/*
 * (non-Javadoc)
 * 
 * @see
 * com.google.zxing.client.android.CaptureActivity#handleDecode(com.google
 * .zxing.Result, android.graphics.Bitmap)
 */
@Override
public void handleDecode(Result rawResult, Bitmap barcode) {

    String barcodeType = rawResult.getBarcodeFormat().toString();
    String productId = rawResult.getText();
 Toast.makeText(getApplicationContext(),"Contents"+productId +"Format"+barcodeType ,Toast.LENGTH_LONG).show();
    //handle intent by sending product id as your wish...

}