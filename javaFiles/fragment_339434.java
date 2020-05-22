ContentValues values = new ContentValues();
values.put(DataEntry.COLUMN_DATA, "1");
String selection = DataEntry._ID + "=?";
String[] selectionArgs = selectedData.toArray(new String[selectedData.size()]);
for each(String s: selectionArgs) {
    int rowsAffected = getContentResolver().update(DataEntry.CONTENT_URI, values, selection, new String[]{s});
}