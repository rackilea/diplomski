public Cursor getRecord(String name) throws SQLException {
  return mDb.query(true, 
    DATABASE_TABLE_RECORDS, 
    new String[] {KEY_ROWID, KEY_DATE, KEY_RECORD_NAME, KEY_TOTAL}, 
    KEY_RECORD_NAME + " = ?",
    new String[] {name},
    null, null, null, null);
}