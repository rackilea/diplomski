@Override  // move your setContentView() method inside activity oncreate()
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
}

public void handleResult(Result result) {
   //handle result
Log.v("handleResult", result.getText());
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setTitle("Scan Result");
builder.setMessage(result.getText());
AlertDialog alertDialog = builder.create();
alertDialog.show();

mScannerView.stopCamera();
updateScannerData(1,result.gettext()); 


//resume scanning
mScannerView.resumeCameraPreview(this);

}