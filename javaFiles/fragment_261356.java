String[] projection = { COLUMN_NAME }
Cursor cursor = mSQLiteDb.query(TABLE_NAME, projection, null, null, null, null, null);

ArrayList<Integer> values = new ArrayList<Integer>();
if (cursor != null && cursor.getCount() != 0) {
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {

        values.add(cursor.getInt(cursor.getColumnIndex(COLUMN_NAME)));

        cursor.moveToNext();
    }
}