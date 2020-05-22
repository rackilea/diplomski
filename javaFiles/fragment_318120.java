public static Bitmap byteArraytoBitmap(byte[] bytes) {
    return (BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
}

public static byte[] bitmaptoByteArray(Bitmap bmp) {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bmp.compress(Bitmap.CompressFormat.PNG, 100, stream); //PNG format is lossless and will ignore the quality setting!
    byte[] byteArray = stream.toByteArray();
    return byteArray;
}

public static Bitmap bitmapFromFile(File file) {
    //returns null if could not decode
    return BitmapFactory.decodeFile(file.getPath());
}

public static boolean saveImage(Bitmap image, String filePath) {
    LogInfo(TAG, "Saving image to: " + filePath);
    File file = new File(filePath);
    File fileDirectory = new File(file.getParent());
    LogInfo(TAG, fileDirectory.getPath());

    if (!fileDirectory.exists()) {
        if (!fileDirectory.mkdirs()) {
            Log.e(TAG, "ERROR CREATING DIRECTORIES");
            return false;
        }
    }

    try {
        file.createNewFile();
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(bitmaptoByteArray(image));
        fo.flush();
        fo.close();
        return true;
    }
    catch (Exception e) {
        e.printStackTrace();
        return false;
    }

}