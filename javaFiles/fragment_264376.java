public static boolean delete(final Context context, final File file) {
    final String where = MediaStore.MediaColumns.DATA + "=?";
    final String[] selectionArgs = new String[] {
            file.getAbsolutePath()
    };
    final ContentResolver contentResolver = context.getContentResolver();
    final Uri filesUri = MediaStore.Files.getContentUri("external");

    contentResolver.delete(filesUri, where, selectionArgs);

    if (file.exists()) {

        contentResolver.delete(filesUri, where, selectionArgs);
    }
    return !file.exists();
}