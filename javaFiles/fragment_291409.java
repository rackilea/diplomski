// Return all data in the database.
public Cursor getAllRows() {
    String where = null;
    Cursor c =  db.query(true, DATABASE_TABLE, ALL_KEYS, 
                        where, null, null, null, KEY_ROWID + " DESC", null);
    if (c != null) {
        c.moveToFirst();
    }
    return c;
}