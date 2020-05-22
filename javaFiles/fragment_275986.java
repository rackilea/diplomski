public List<NotesModel> getAllNotes() {
        List<NotesModel> notesList = new ArrayList<NotesModel>();

StringBuffer selectQuery = new StringBuffer();
selectQuery.append("SELECT * FROM "+myDB.TABLE_NAME+"");

        Cursor cursor = sql.rawQuery(selectQuery.toString(),null);

if (cursor != null && cursor.moveToFirst()) {
            do {
               NotesModel notes = new NotesModel();
            notes.setId(cursor.getInt(0));
            notes.setTitle(cursor.getString(1));
            notes.setBody(cursor.getString(2));

            notesList.add(notes);

            } while (cursor.moveToNext());
        }


        cursor.close();
        return notesList;
    }