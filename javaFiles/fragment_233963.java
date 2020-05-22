@Override
protected void onResume() {
    super.onResume();
    String[] selectionArgs = {String.valueOf(globalVariable.getQuestion_number())};
    c = myDbHelper.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    if (c.moveToFirst()) {
        do {
            question_no.setText(c.getString(0));
            ques_text.setText(c.getString(1));
            option1.setText(c.getString(2));
            option2.setText(c.getString(3));
            option3.setText(c.getString(4));
            option4.setText(c.getString(5));
            answer_text = c.getString(6);
            Toast.makeText(activityQuiz.this,
            "_id: " + c.getString(0) + "\n"+
            "_answer" + c.getString(6),
            Toast.LENGTH_LONG).show();
        } while (c.moveToNext());
    }
}