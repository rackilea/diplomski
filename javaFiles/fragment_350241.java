class Question{
    String question;
    String answer1, answer2, answer3, answer4;
    int userAnswer;
    int correctAnswer;
    boolean scoredPoints;
    Question(String q, int correct, String a1, String a2, String a3, String a4){
        this.question = q;
        this.correctAnswer = correct;
        this.answer1 = a1;
        this.answer2 = a2;
        this.answer3 = a3;
        this.answer4 = a4;

    }
}