package com.answer.stack.overflow.questionnaire;

import java.util.Set;
import java.util.TreeSet;

public class Topic {
  private String title;

  private Set<Question> questions = new TreeSet<Question>();

  public Topic(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void addQuestion(Question question) {
    questions.add(question);
  }

  public Set<Question> getQuestions() {
    return questions;
  }

  @Override
  public String toString() {
    String text = "Topic is ... " + title + "\n";

    for (Question question : questions) {
      text += question.toString() + "\n";
    }

    return text;
  }
}