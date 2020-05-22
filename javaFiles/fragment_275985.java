public List<NotesModel> getAllNotes() {
        List<NotesModel> notesList = new ArrayList<NotesModel>();

        Cursor cursor = sql.query(myDB.TABLE_NAME, getAllColumns, null, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            NotesModel notes = new NotesModel();
            notes.setId(cursor.getInt(0));
            notes.setTitle(cursor.getString(1));
            notes.setBody(cursor.getString(2));

            notesList.add(notes);
            cursor.moveToNext();
        }

        cursor.close();
        return notesList;
    }