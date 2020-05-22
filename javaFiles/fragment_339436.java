ContentValues values = new ContentValues();
values.put(DataEntry.COLUMN_DATA, "1");
String[] selectionArgs = selectedData.toArray(new String[selectedData.size()]);
StringBuilder sb = new StringBuilder("IN (");
for (int i=0; i < selectionArgs.length(); i++) {
    if (i < (selectionArgs.length() - 1) {
        sb.append("?,");
    } else {
        sb.append("?)");
    }
}        
int rowsAffected = getContentResolver().update(DataEntry.CONTENT_URI, values, sb.toString, selectionArgs);