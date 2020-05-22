package com.answer.stack.overflow.questionnaire;

public class Question implements Comparable<Question> {
  private String text;
  private String code;

  private Answer correctAnswer;

  public Question(String code, String text, String correctAnswerText) {
    this.code = code;
    this.text = text;
    this.correctAnswer = new Answer(code, correctAnswerText);
  }

  public String getText() {
    return text;
  }

  public String getCode() {
    return code;
  }

  public boolean isCorrect(String answer) {
    return correctAnswer.getText().equalsIgnoreCase(answer);
  }

  @Override
  public int compareTo(Question o) {
    return code.compareToIgnoreCase(o.code);
  }

  @Override
  public String toString() {
    return code + ": " + text + " (" + correctAnswer.getText() + ")";
  }
}