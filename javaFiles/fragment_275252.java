long addQuestion(String Question, String Answer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, Question); // question Name
        values.put(KEY_ANSWER, Answer); // answer

        // Inserting Row
        return db.insert(TABLE_QUESTIONS, null, values);
        //db.close(); // Closing database connection
    }