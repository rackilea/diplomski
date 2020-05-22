public class UploadHelper {

/**
 * Turn drawable resource into byte array.
 *
 * @param context parent context
 * @param id      drawable resource id
 * @return byte array
 */
public static byte[] getFileDataFromDrawable(Context context, int id) {
    Drawable drawable = ContextCompat.getDrawable(context, id);
    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
}

/**
 * Turn drawable into byte array.
 *
 * @return byte array
 */
public static  byte[] getFileDataFromDrawable(Context context, Uri uri) {
    // Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
        InputStream iStream =   context.getContentResolver().openInputStream(uri);
        int bufferSize = 2048;
        byte[] buffer = new byte[bufferSize];

        // we need to know how may bytes were read to write them to the byteBuffer
        int len = 0;
        if (iStream != null) {
            while ((len = iStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    //  bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
}