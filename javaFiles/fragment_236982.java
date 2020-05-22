@Override
public int delete(Uri uri, String selection, String[] selectionArgs) {
   // ContentProvider has already checked granted permissions
   final File file = mStrategy.getFileForUri(uri);   /* line 497 */
   return file.delete() ? 1 : 0;
}