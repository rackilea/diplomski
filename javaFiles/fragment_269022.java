public long getAmountSum(){
    long rv = 0;
    String[] columns = new String[]{"sum(" + COL4 + ")"};
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor csr = db.query(TABLE_NAME,columns,null,null,null,null,null);
    if (csr.moveToFirst()) {
        rv = csr.getLong(0);
    }
    csr.close();
    return rv;
}