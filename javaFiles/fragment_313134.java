/**
 * Gets the MediaStore video ID of a given file on external storage
 * @param filePath The path (on external storage) of the file to resolve the ID of
 * @param contentResolver The content resolver to use to perform the query.
 * @return the video ID as a long
 */
private long getImageIdFromFilePath(String filePath,
    ContentResolver contentResolver) {


    long imageId;
    Log.d(TAG,"Loading file " + filePath);

            // This returns us content://media/external/images/media (or something like that)
            // I pass in "external" because that's the MediaStore's name for the external
            // storage on my device (the other possibility is "internal")

    Uri imagesUri = MediaStore.Images.getContentUri("external");

    Log.d(TAG,"imagesUri = " + imagessUri.toString());

    String[] projection = {MediaStore.Images.ImageColumns._ID};

    // TODO This will break if we have no matching item in the MediaStore.
    Cursor cursor = contentResolver.query(imagesUri, projection, MediaStore.Images.ImageColumns.DATA + " LIKE ?", new String[] { filePath }, null);
    cursor.moveToFirst();

    int columnIndex = cursor.getColumnIndex(projection[0]);
    imageId = cursor.getLong(columnIndex);

    Log.d(TAG,"Image ID is " + imageId);
    cursor.close();
    return imageId;
}