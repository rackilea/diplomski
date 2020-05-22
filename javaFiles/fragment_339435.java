ContentValues values = new ContentValues();
values.put(DataEntry.COLUMN_DATA, "1");
String selection " IN (?)";
String[] selectionArgs = selectedData.toArray(new String[selectedData.size()]);
StringBuilder sb = new StringBuilder();
for (int i=0; i < selectionArgs.length(); i++) {
    sb.append(selectionArgs[i]);
    if (i < (selectionArgs.length - 1)) {
        sb.append(",");
    }
}        
int rowsAffected = getContentResolver().update(DataEntry.CONTENT_URI, values, selection, new String[]{sb.toString()});