private void saveBitmap(Bitmap bitmap) {
    try {
        File storageDir = createImageFile();
        String path = storageDir.toString();
        OutputStream out = new FileOutputStream(path);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        out.close();

        MyMediaConnectorClient client = new MyMediaConnectorClient(path);
        MediaScannerConnection scanner = new MediaScannerConnection(
                Context, client);
        client.setScanner(scanner);
        scanner.connect();

    } catch (IOException e) {
        Log.e("save image", "failed to save image", e);
    }
}