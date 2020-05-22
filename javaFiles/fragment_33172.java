@Override
protected void onPause() {
    super.onPause();
    if(zXingScannerView!=null)
    zXingScannerView.stopCamera();
}