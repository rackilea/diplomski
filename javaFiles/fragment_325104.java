@Override
public void handleResult(me.dm7.barcodescanner.zbar.Result result) {
    // Do something with the result here
    Log.v("kkkk", result.getContents()); // Prints scan results
    Log.v("uuuu", result.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)

    Intent mainActivity = new Intent(this,MainActivity.class);
    mainActivity.putExtra("tvresult1",result.getContents().toString());
    setResult(Activity.RESULT_OK, mainActivity);
    finish(); //exiting your ScanActivity
}