import java.awt.*;
import javax.swing.*;
public class DialogExamples {
    String[] answers = new String[] {"A1", "A2", "A3", "A4"};
    String[] questions = new String[] {"Q1", "Q2", "Q3", "Your score: "};
    int response = -2; //-2 because I'm not sure what value does response has, -1 or 3 on the last option
    int i = 0;
    int score = 0;
    String message = "";
    public DialogExamples() {
        do {
            message = i < 3 ? questions[i] : questions[i] + score;
            while (response != 0) { //Correct answer is A1
                response = JOptionPane.showOptionDialog(null, message, "Title",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, answers, answers[0]);
            }
            i++;
            score++; //Add your logic
            response = -2;
        } while (i < questions.length); //i = number of questions
    }

    public static void main (String args[]) {
        DialogExamples de = new DialogExamples();
    }
}