@Override
public void handleResult(Result result) {
    String resultBarcode = result.getText();
    Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
    intent.putExtra("barcode", resultBarcode.toString());
    startActivity(intent);
    scannerView.stopCamera();
}