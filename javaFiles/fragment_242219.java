public BarcodeScanningProcessor(Context context) {
    // Note that if you know which format of barcode your app is dealing with, detection will be
    // faster to specify the supported barcode formats one by one, e.g.
    // new FirebaseVisionBarcodeDetectorOptions.Builder()
    // .setBarcodeFormats(FirebaseVisionBarcode.FORMAT_QR_CODE)
    // .build();
    detector = FirebaseVision.getInstance().getVisionBarcodeDetector();
    this.mContext = context;
}