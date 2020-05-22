public String fetchThePassword(long paramLong) throws SQLException {
    SQLiteDatabase localSQLiteDatabase = this.db;
    String[] columns = new String[] { "pass" };
    Cursor cursor = localSQLiteDatabase.query(true, "register", columns, "id=" + paramLong,
            null, null, null, null, null);

    String result = null;
    if (cursor.moveToFirst()) {
        // value from the pass column 
        result = cursor.getString(0);
    }
    cursor.close();
    // result is either the pass or null
    return result;
}