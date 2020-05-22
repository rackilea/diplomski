public long[] arrayFromCursor(Cursor cursor) {

    int length = cursor.getCount();
    long[] array = new long[length];

    if (cursor.moveToFirst()) {
        for (int i = 0; i < length; i++) {
            array[i] = cursor.getLong(cursor.getColumnIndex("column_name"));
            cursor.moveToNext();
        }
    }
    return array;
}