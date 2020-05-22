package com.answer.stack.overflow.questionnaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Questionnaire {
  private List<Topic> topics = new ArrayList<Topic>();

  public void addTopic(Topic topic) {
    topics.add(topic);
  }

  public void checkAnswers(Map<String, String> answers) {
    for (Topic topic : topics) {
      for (Question question : topic.getQuestions()) {
        String code = question.getCode();
        String answerText = answers.get(code);

        if (answerText == null) {
          System.out.println("Answer not provided for question " + code + ".");
        } else if (!question.isCorrect(answerText)) {
          System.out.println("\"" + answerText + "\" is an incorrect answer for question " + code + ".");
        } else {
          System.out.println("Question " + code + " was answered correctly!");
        }
      }
    }
  }

  @Override
  public String toString() {
    String text = "";

    for (Topic topic : topics) {
      text += topic.toString() + "\n";
    }

    return text;
  }

  public static void main(String[] args) {
    Questionnaire questionnaire = new Questionnaire();
    Map<String, String> answers = new HashMap<String, String>();
    Topic topic = new Topic("My attributes");

    topic.addQuestion(new Question("1A", "What is my name?", "Anonymous"));
    topic.addQuestion(new Question("1B", "How tall am I?", "190 cm"));

    questionnaire.addTopic(topic);

    topic = new Topic("Maths");

    topic.addQuestion(new Question("2A", "How much is 1+1?", "2"));
    topic.addQuestion(new Question("2B", "How much is 3/0?", "Not a number"));

    questionnaire.addTopic(topic);

    System.out.println(questionnaire.toString());

    answers.put("1B", "190 cm");
    answers.put("2A", "2");
    answers.put("2B", "infinite?");

    questionnaire.checkAnswers(answers);
  }
}