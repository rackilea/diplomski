import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Solution {

    public static void main(String[] args)  {
        List<Question> quiz = getQuiz("inputFile.xml");

        printQuiz(quiz);
    }

    public static List<Question> getQuiz(String fileName) {
        List<Question> quiz = null;

        try {
            // parser instantiation
            InputStream in = new FileInputStream(fileName);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);

            String currentData = null, currentCategory = null, currentQuestion = null, currentRightAnswer = null;
            quiz = new LinkedList<>();
            List<String> badAnswers = new LinkedList<>();   // first instantiation of badAnswers list
            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if (parser.getLocalName().equals("questionReponse")) {
                            Question question = new Question(currentCategory, currentQuestion, currentRightAnswer, badAnswers);
                            quiz.add(question);
                            badAnswers = new LinkedList<>();    // Renew badAnswers after each Question entry insert
                        }               
                        if (parser.getLocalName().equals("categorie")) {
                            currentCategory = currentData;
                        }
                        if (parser.getLocalName().equals("question")) {
                            currentQuestion = currentData;
                        }
                        if (parser.getLocalName().equals("reponse")) {
                            currentRightAnswer = currentData;
                        }
                        if (parser.getLocalName().equals("mauvaiseReponse")) {
                            badAnswers.add(currentData);
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        currentData = parser.getText();
                        break;
                }
            }   // end of for loop
            parser.close();

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return quiz;
    }

    public static void printQuiz(List<Question> quiz) {
        int i = 1;
        for(Question q : quiz) {
            System.out.println("Question    : " + i++);
            System.out.printf("\tCategory   : %s\n" , q.getCurrentCategory());
            System.out.printf("\tQuestion   : %s\n" , q.getCurrentQuestion());
            System.out.printf("\tAnswer     : %s\n" , q.getCurrentRightAnswer());
            System.out.printf("\tBad Answers: %s\n" , q.getBadAnswers());
            System.out.println("***********************\n");
        }
    }

}

class Question {

    private String currentCategory;
    private String currentQuestion;
    private String currentRightAnswer;
    private List<String> badAnswers;

    public Question(String currentCategory, String currentQuestion, String currentRightAnswer, List<String> badAnswers) {
        this.currentCategory = currentCategory;
        this.currentQuestion = currentQuestion;
        this.currentRightAnswer = currentRightAnswer;
        this.badAnswers = badAnswers;
    }

    public String getCurrentCategory() {
        return currentCategory;
    }

    public String getCurrentQuestion() {
        return currentQuestion;
    }

    public String getCurrentRightAnswer() {
        return currentRightAnswer;
    }

    public List<String> getBadAnswers() {
        return badAnswers;
    }

}