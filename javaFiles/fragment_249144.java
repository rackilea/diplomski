private void addQuestionsBasics(thequestion, SQliteDatabase db) {

    QuestionBasics q101 = new QuestionBasics("What is pitch?", "The length of a sound", "The overall quality of a sound", "The highness or lowness of a sound", "The volume of a sound", "The highness or lowness of a sound", "B");
    db.addQuestionBasics(q101); //<<<<<<<<<< CHANGED
    QuestionBasics q102 = new QuestionBasics("What is 'timbre'?", "The ove", "format it", "compile it", "hardware it", "format it", "B");
    db.addQuestionBasics(q102); //<<<<<<<<<< CHANGED
    ....... and so on