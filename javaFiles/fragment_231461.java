private Bitmap getBitmap() {
    Bitmap bitmap = Bitmap.createBitmap(mPieToss.getWidth(),
            mPieToss.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    // Draw things to your canvas. They will be included as your BitMap, which is saved later on


    return bitmap;
}

public void save() {
    Bitmap bitmap = getBitmap();

    File path = Environment
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
            .format(new Date());

    String filename = "Imagen_" + timestamp + ".jpg";
    File file = new File(path, filename);
    FileOutputStream stream;
    // This can fail if the external storage is mounted via USB
    try {
        stream = new FileOutputStream(file);
        bitmap.compress(CompressFormat.PNG, 100, stream);
        stream.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    mUri = Uri.fromFile(file);

    bitmap.recycle();
}