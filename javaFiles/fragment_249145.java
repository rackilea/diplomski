String basicsTableCreate = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST1 + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
            + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
            + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD + " TEXT, " + KEY_CAT + " TEXT)";
    db.execSQL(basicsTableCreate);
    addQuestionsBasics(db);

     //............. code shortened for test ..........
}

private void addQuestionsBasics(SQLiteDatabase db) { //<<<<<<<<<< CHANGED
    QuestionBasics q101 = new QuestionBasics("What is pitch?", "The length of a sound", "The overall quality of a sound", "The highness or lowness of a sound", "The volume of a sound", "The highness or lowness of a sound", "B");
    this.addQuestionBasics(q101,db);
    QuestionBasics q102 = new QuestionBasics("What is 'timbre'?", "The ove", "format it", "compile it", "hardware it", "format it", "B");
    this.addQuestionBasics(q102,db);

    //............. code shortened for test ..........
}

//<<<<<<<<<< NEW >>>>>>>>>>
public void addQuestionsBasics(QuestionBasics quest) {
    addQuestionBasics(quest,this.getWritableDatabase());
}

public void addQuestionBasics(QuestionBasics quest, SQLiteDatabase db) { //<<<<<<<<<< CHANGED
    ContentValues contentValues = new ContentValues();
    contentValues.put(KEY_QUES, quest.getQUESTION1());
    contentValues.put(KEY_ANSWER, quest.getANSWER1());
    contentValues.put(KEY_OPTA, quest.getOPTA1());
    contentValues.put(KEY_OPTB, quest.getOPTB1());
    contentValues.put(KEY_OPTC, quest.getOPTC1());
    contentValues.put(KEY_OPTD, quest.getOPTD1());
    contentValues.put(KEY_CAT, quest.getCATEGORY1());
    // Inserting Row
    dbase.insert(TABLE_QUEST1, null, contentValues);