class Answer
{
    private int questionID;
    private int answerID;
    private boolean correct;

    public Answer(int questionID, int answerID, boolean correct)
    {
        this.questionID = questionID;
        this.answerID = answerID;
        this.correct = correct;
    }
}