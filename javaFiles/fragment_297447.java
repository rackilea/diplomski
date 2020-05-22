public List<Question> getAllQuestions() {
    List<Question> quesList = new ArrayList<Question>();
    int nQuestions = 3; //select COUNT(*) from questions

    Random random = new Random();

    String query = "SELECT * FROM " + TABLE_QUEST + " WHERE ";
    for (int x = 0; x < nQuestions; x++) {
        if (x > 0) {
            query += " OR ";
        }
        query += "id=" + random.nextInt(5);
    }

    dbase=this.getReadableDatabase();
    Cursor cursor = dbase.rawQuery(query, null);
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            Question quest = new Question();
            quest.setID(cursor.getInt(0));
            quest.setQUESTION(cursor.getString(1));
            quest.setANSWER(cursor.getString(2));
            quest.setOPTA(cursor.getString(3));
            quest.setOPTB(cursor.getString(4));
            quest.setOPTC(cursor.getString(5));
            quesList.add(quest);
        } while (cursor.moveToNext());
    }
    // return quest list
    return quesList;
}