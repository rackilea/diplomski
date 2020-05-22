public class Question {
  private String question;
  private int answer = 1;

  public Question(String question, int answer) {
    this.question = question;
    if (answer > 0) {
      this.answer = answer;
    } else {
      System.err.println("0 is no answer (e.g. not a value)");
    }
  }

  public boolean isAnswerCorrect(Integer answer) {
    return this.answer == (int) answer;
  }

  public int getCorrectAnswer() {
    return answer;
  }

  public String toString() {
    return question;
  }
}