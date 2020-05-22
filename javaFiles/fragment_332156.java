void addNote(NotePad notePad) {
    SQLiteDatabase database = this.getWritableDatabase();
    cv = new ContentValues();
    if (!TextUtils.isEmpty(notePad.getTitle())) cv.put(TITLE, notePad.getTitle());
    cv.put(CONTENT, notePad.getContent());
    cv.put(DATE, notePad.getDate());
    cv.put(TIME, notePad.getTime());

    database.insert(DATABASE_TABLE, null, cv);
}