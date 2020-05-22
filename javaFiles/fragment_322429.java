public abstract class Question<AnswerType> {
  private String question;
  private AnswerType answer;

  public Question(String question, AnswerType answer) {
    this.question = question;
    this.answer = answer;
  }

  public abstract boolean checkAnswer(AnswerType yourAnswer);

  protected AnswerType getAnswer() {
    return answer;
  }
}

class TextQuestion extends Question<String> {
  public TextQuestion(String question, String answer) {
    super(question, answer);
  }

  public boolean checkAnswer(String yourAnswer) {
    return answer.equals(yourAnswer);
  }
}

class NumberQuestion extends Question<Double> {
  private double epsilon;

  public NumberQuestion(String question, Double answer, double epsilon) {
    super(question, answer);
    this.epsilon = epsilon;
  }

  public boolean checkAnswer(Double yourAnswer) {
    return Math.abs(getAnswer() - yourAnswer) < epsilon;
  }
}