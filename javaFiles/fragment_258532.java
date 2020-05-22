public String readDataMatrix(Bitmap bitmap) {
        int width = bitmap.getWidth();
        height = bitmap.getHeight();
        byte[] data = bitmap.getRowBytes();

        Result rawResult = null;
        Log.e("C2", data.length + " (" + width + "x" + height + ")");
        PlanarYUVLuminanceSource source = new PlanarYUVLuminanceSource(data, width, height);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        try {
            rawResult = mQrReader.decode(bitmap);
            onQRCodeRead(rawResult.getText());
        } catch (ReaderException ignored) {
            /* Ignored */
        } finally {
            mQrReader.reset();
        }

        Result rawResult = null;

        if (rawResult != null) {
            Log.i(TAG, "==============================================");
                Log.i(TAG, rawResult.getText());
            Log.i(TAG, "==============================================");
        } 

        return rawResult != null ? rawResult.getText() : null;
    }