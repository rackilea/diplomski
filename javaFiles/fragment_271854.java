public void endQuiz() {
    Intent intent = new Intent(QuestionView.this, Results.class);
    intent.putExtras("correct", correctAnswers);
    intent.putExtras("wrong", wrongAnswers);
    intent.putExtras("queries", queries); // You will need to make Question implement Parcelable 
    startActivity(intent);
}