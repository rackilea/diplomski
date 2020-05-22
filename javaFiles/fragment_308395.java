public void updateNote(Note note) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_TITLE, note.getTitle());
    values.put(KEY_CONTENT, note.getContent());
    values.put(KEY_METADATA, note.getMetadata());

    db.update(TABLE_NOTES, values, KEY_ID + " = ?",
            new String[]{String.valueOf(note.getID())});

    db.close();
}