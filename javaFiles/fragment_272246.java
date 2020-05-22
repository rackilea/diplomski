public Cursor fetchAllData() {
    SQLiteDatabase mDb = getWritableDatabase();
        Cursor mCursor = mDb.query(ITEMS_TABLE, new String[]{COLUMN_ID, COLUMN_NAME},
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }