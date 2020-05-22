import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Testing2 extends JFrame implements ActionListener {

    private double score;
    protected double totalScore;
    protected double averageScore;
    protected int counter = 0;
    JButton next = new JButton("Next");
    JButton display = new JButton("Display");
    JTextField scoreField = new JTextField("0", 3);
    JTextField commentField = new JTextField(30);
    JLabel explainationLabel = new JLabel(
            "Please Score your overall                 saticfaction with our app");
    JLabel explainationLabel2 = new JLabel("Enter any comments or suggestions");
    JLabel testDisplay = new JLabel();

    public Testing2() {
        super("App Survey");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(explainationLabel);
        add(scoreField);
        add(explainationLabel2);
        add(commentField);
        add(next);
        add(display);
        add(testDisplay);
        next.addActionListener(this);
        display.addActionListener(this);
    }

    public Testing2(String t) {
        super(t);
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == next) {
            score = Double.parseDouble(scoreField.getText());
            if (score < 11 && score > 0) {
                totalScore += score;
                counter++;
                scoreField.setText("0");
                commentField.setText("");
            } else
                JOptionPane.showMessageDialog(null, "Please enter a score bettween 1 and 10",
                        "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            averageScore = totalScore / counter;
            testDisplay.setText("The average score is: " + averageScore + " out of " + counter
                    + " votes.");
            viewLoginFrame();
        }
    }

    public static void main(String[] args) {
        Testing2 testFrame = new Testing2();
        final int WIDTH = 375;
        final int HEIGHT = 200;
        testFrame.setSize(WIDTH, HEIGHT);
        testFrame.setVisible(true);
    }

    public void viewLoginFrame() {
        // !! SecondFrame2 loginFrame = new SecondFrame2();
        SecondFrame2 loginFrame = new SecondFrame2(this); // !!
        final int WIDTH = 300;
        final int HEIGHT = 200;
        loginFrame.setSize(WIDTH, HEIGHT);
        loginFrame.setVisible(true);
    }

    public double getAverageScore() {
        return averageScore;
    }

    public int getCounter() {
        return counter;
    }
}

class SecondFrame2 extends JFrame {
    JLabel displayScore = new JLabel();
    JLabel displayScore2 = new JLabel();
    JLabel displayCommentCounter = new JLabel();
    private Testing2 testing2; // set up field if we need it

    // !! accept a Testing2 object in parameter
    public SecondFrame2(Testing2 testing2) {
        super("Survey Results");
        this.testing2 = testing2; // use the parameter to set the reference
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(displayScore);
        add(displayScore2);
        add(displayCommentCounter);
        displayScore.setText("The average overall saticfaction");

        // !! extract the information we need by calling methods on testing2:

        // displayScore2.setText("score for the day is: " + averageScore);
        displayScore2.setText("score for the day is: " + testing2.getAverageScore());
        // displayCommentCounter.setText("The total number of Surveys taken was: " + counter);
        displayCommentCounter.setText("The total number of Surveys taken was: " + testing2.getCounter());

    }
}