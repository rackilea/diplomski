public void onPictureTaken(byte[] data, Camera camera){
    MultiFormatReader reader = new MultiFormatReader();
    Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
    Collection<BarcodeFormat> possible_types = new ArrayList<BarcodeFormat>();

    possible_types.add(BarcodeFormat.UPC_A);
    possible_types.add(BarcodeFormat.UPC_E);
    possible_types.add(BarcodeFormat.EAN_8);
    possible_types.add(BarcodeFormat.EAN_13);
    possible_types.add(BarcodeFormat.QR_CODE);
    possible_types.add(BarcodeFormat.DATA_MATRIX);

    hints.put(DecodeHintType.POSSIBLE_FORMAT, possible_types);
    hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);

    Result result = null;

    for(int i = 0; i < 4; i++){
        BinaryBitmap bitmap = BinaryBitmapFromJpegData(data, i * 90);

        try {
            result = reader.decode(bitmap, hints);
            break;
        } catch (NotFoundException e) {}
    }

    if(result == null){
        Toast.makeText(context, "No Barcode Found", Toast.LENGTH_LONG).show();
    } else {
        Toast.makeText(context, "Found barcode: " + result.getText(), Toast.LENGTH_LONG).show();
    }
}

private BinaryBitmap BinaryBitmapFromJpegData(byte[] data, int rotation){
    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

    if(rotation != 0){
        bitmap = RotateBitmap(bitmap, rotation);
    }

    int[] intArray = new int[bitmap.getWidth() * bitmap.getHeight()];
    bitmap.getPixels(intArray, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

    LuminanceSource source = new RGBLuminanceSource(bitmap.getWidth(), bitmap.getHeight(), intArray);
    BinaryBitmap bbm = new BinaryBitmap(new HybridBinarizer(source));

    return bbm;
}

public static Bitmap RotateBitmap(Bitmap source, float angle){
    Matrix matrix = new Matrix();
    matrix.postRotate(angle);
    return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
}