public File getFileFromContentUri(final Uri uri) 
{
    if (uri == null || !(uri.getScheme().equals("content") || uri.toString().contains("file://"))) return null;

    if (uri.getScheme().equals("content")) {
        final String[] columns = new String[] {MediaStore.MediaColumns.DATA};
        final Cursor cursor = getContentResolver().query(uri, columns, null, null, null);
        if (cursor == null || cursor.getCount() == 0) return null;
        cursor.moveToFirst();
        final String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA));
        if (path != null) return new File(path);
        else return null;
   }
   else if (uri.toString().contains("file://")) {
       return new File(uri.getPath());
   }

   return null;
}