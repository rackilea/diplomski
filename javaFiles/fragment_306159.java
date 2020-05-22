public Cursor getAllRows() {
    String where = null;
    String Order = "foo DESC";
    Cursor c =  db.query(true, DATABASE_TABLE, ALL_KEYS, 
                        where, null, null, null,Order,null);
    if (c != null) {
        c.moveToFirst();
    }
    return c;