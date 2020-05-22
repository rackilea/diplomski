@Override
public void handleResult(Result result) {
    String resultBarcode = result.getText();
    Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
    intent.putExtra("barcode", resultBarcode.toString());
    intent.putExtra("Profile", selectedArray);
    startActivity(intent);
    scannerView.stopCamera();
}