// this is a small sample use of the QRCodeEncoder class from zxing
try {
    // generate a 150x150 QR code
    Bitmap bm = encodeAsBitmap(barcode_content, BarcodeFormat.QR_CODE, 150, 150);

    if(bm != null) {
        image_view.setImageBitmap(bm);
    }
} catch (WriterException e) { //eek }