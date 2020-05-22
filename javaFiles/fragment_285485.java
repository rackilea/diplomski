public long insertRows(SQLiteDatabase db, String tableName, ContentValues contentValues) {
        long n = db.insert(tableName, null, contentValues);

        Util.printMessage(TAG, "Row inserted in " + tableName + " : " + n);
        return n;
    }