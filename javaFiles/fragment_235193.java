public int getBucketExp(long id) {
    String[] columns = new String[] { KEY_BUCKETEXP };
    String where = KEY_ROWID + " = ?";
    String[] whereArgs = new String[] { Long.toString(id) };

    Cursor cursor = ourDatabase.query(DATABASE_TABLE, columns, where, whereArgs,
            null, null, null);

    int bucketExp = 0;
    if (cursor.moveToFirst()) {
        bucketExp = cursor.getInt(cursor.getColumnIndex(KEY_BUCKETEXP));
    }

    return bucketExp;
}