public boolean saveImageToInternalStorage(Bitmap image) {
    try {
        FileOutputStream fos = context.openFileOutput("yourimage.png", Context.MODE_PRIVATE);
        // Writing the bitmap to the output stream
        image.compress(Bitmap.CompressFormat.PNG, 100, fos);
        fos.close();
        return true;
    } catch (Exception e) {
        Log.e("saveToInternalStorage()", e.getMessage());
        return false;
    }
}