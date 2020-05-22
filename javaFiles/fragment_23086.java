public boolean ifValidUserLogin(String username, String password) {
    SQLitedarabase db = this.getWriteableDatabase();
    Cursor csr = db.query(YOUR_TABLE_NAME,
        null,    // null equates to all columns
        "username" + "=? AND " +
            "password" + "=?", // the WHERE clause less WHERE
        new String[]{username,password}, // the arguments that replace ?'s
        null,null,null
    };
    boolean rv = (csr.getCount > 0);
    csr.close();
    return rv;
}