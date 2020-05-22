public long getValidUserId(String username, String password) {
    long rv = -1; // default to mismatch and thus no id (could use 0)
    SQLitedarabase db = this.getWriteableDatabase();
    Cursor csr = db.query(YOUR_TABLE_NAME,
        null,    // null equates to all columns
        "username" + "=? AND " +
            "password" + "=?", // the WHERE clause less WHERE
        new String[]{username,password}, // the arguments that replace ?'s
        null,null,null
    };
    if (csr.moveToFirst) {
        rv = csr.getLong(csr.getColumnIndex("YOUR_ID_COLUMNNAME"));
    }
    csr.close();
    return rv;
}