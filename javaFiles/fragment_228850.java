public Cursor getTestDataGradovi(long id) {
    String sql = "SELECT * FROM tblGradovi WHERE _ID = " + id;
    Cursor c = mDb.rawQuery(sql, null);
    c.moveToNext();
    return c;
}