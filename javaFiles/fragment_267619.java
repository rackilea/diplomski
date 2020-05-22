Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_DAYS,
        new String[]{ DatabaseHelper.COLUMN_DAY_ID },
        null, null, null, null,
        DatabaseHelper.COLUMN_DAY_ID + " DESC",
        "2");
long secondToLastDay = 0, lastDay = 0;
if (cursor.moveToFirst()) {
    lastDay = cursor.getLong(0);
    if (cursor.moveToNext())
        secondToLastDay = cursor.getLong(0);
}