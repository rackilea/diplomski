public class Question {
    @DrawableRes
    private int imageId;
    private String[] answers;
    private int correctAnswerIndex;

    public Question(int imageId, int correctAnswerIndex, String... answers) {
        this.imageId = imageId;
        this.correctAnswerIndex = correctAnswerIndex;
        this.answers = answers;
    }

    @DrawableRes
    public int getImageId() { return imageId; }
    public String[] getAnswers() { return answers; }
    public int getCorrectAnswerIndex() { return correctAnswerIndex; }
}