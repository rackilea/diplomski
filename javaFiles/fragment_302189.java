Cursor getAllPersons() {
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.query(TABLE_PERSON, new String[]{KEY_ID,
            KEY_NAME, KEY_BUDGET}, null, null, null, null, null);

    return cursor;
}