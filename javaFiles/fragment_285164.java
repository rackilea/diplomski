public Cursor getRowID(String _name) {
    String where = "name = '" + _name + "'";
    Cursor c = db.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null,
            null, null, null);
    if (c != null) {
        c.moveToFirst();
    }
    return c;
}