float photoRotation = 0;
boolean hasRotation = false;
String[] projection = { Images.ImageColumns.ORIENTATION };
try {
    Cursor cursor = getActivity().getContentResolver().query(photoUri, projection, null, null, null);
    if (cursor.moveToFirst()) {
        photoRotation = cursor.getInt(0);
        hasRotation = true;
    }
    cursor.close();
} catch (Exception e) {}

if (!hasRotation) {
    ExifInterface exif = new ExifInterface(photoUri.getPath());
    int exifRotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_UNDEFINED);

    switch (exifRotation) {
        case ExifInterface.ORIENTATION_ROTATE_90: {
            photoRotation = 90.0f;
            break;
        }
        case ExifInterface.ORIENTATION_ROTATE_180: {
            photoRotation = 180.0f;
            break;
        }
        case ExifInterface.ORIENTATION_ROTATE_270: {
            photoRotation = 270.0f;
            break;
        }
    }
}