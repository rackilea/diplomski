public void insertChecklist(Checklist checklist) {
    SQLiteDatabase db = this.getWritableDatabase();
    try {
        ContentValues values = new ContentValues();
        values.put(ChecklistContract.COLUMN_NAME_START_TIME, checklist.getStartTime());
        values.put(ChecklistContract.COLUMN_NAME_END_TIME,   checklist.getEndTime());

        long id;
        id = db.insertOrThrow(ChecklistContract.TABLE_NAME, null, values);
        checklist.setId(id);
    } finally {
        db.close();
    }
}