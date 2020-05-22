private void saveBitmap(@NonNull final Context context, @NonNull final Bitmap bitmap,
                        @NonNull final Bitmap.CompressFormat format, @NonNull final String mimeType,
                        @NonNull final String displayName) throws IOException
{
    final String relativeLocation = Environment.DIRECTORY_PICTURES;

    final ContentValues  contentValues = new ContentValues();
    contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, displayName);
    contentValues.put(MediaStore.MediaColumns.MIME_TYPE, mimeType);
    contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, relativeLocation);

    final ContentResolver resolver = context.getContentResolver();

    OutputStream stream = null;
    Uri uri = null;

    try
    {
        final Uri contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        uri = resolver.insert(contentUri, contentValues);

        if (uri == null)
        {
            throw new IOException("Failed to create new MediaStore record.");
        }

        stream = resolver.openOutputStream(uri);

        if (stream == null)
        {
            throw new IOException("Failed to get output stream.");
        }

        if (bitmap.compress(format, 95, stream) == false)
        {
            throw new IOException("Failed to save bitmap.");
        }
    }
    catch (IOException e)
    {
        if (uri != null)
        {
            // Don't leave an orphan entry in the MediaStore
            resolver.delete(uri, null, null);
        }

        throw e;
    }
    finally
    {
        if (stream != null)
        {
            stream.close();
        }
    }
}