if (cursor != null && cursor.moveToFirst()) {
            Note newNote=cursorToNote(cursor);
            cursor.close();
            return  newNote;
    } 
    else {
        return null;
    }