// query the DBAdapter
Cursor cursor = db.query(true, TABLE_NAME, ALL_KEYS, where, null, null, null, null, null);
if (cursor != null) {
    cursor.moveToFirst();
}
return cursor;