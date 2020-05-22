try {
    FileOutputStream fos = new FileOutputStream(file);
    image.compress(Bitmap.CompressFormat.PNG, 90, fos);
    fos.close();
} catch (FileNotFoundException e) {
    Log.d(TAG, "File not found: " + e.getMessage());
    badHandler.handleMessage(new Message());
    return;
} catch (IOException e) {
    Log.d(TAG, "Error accessing file: " + e.getMessage());
    badHandler.handleMessage(new Message());
    return;
}
goodHandler.handleMessage(new Message());