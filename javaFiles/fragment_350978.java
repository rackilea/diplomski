package justtest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class QuizCardTestDrive /*extends QuizCard*/ {

    public static void main(String[] args) {
        QuizCardBuilder qb = new QuizCardBuilder();

        QuizCard b5 = new QuizCard();
        System.out.println("The Answer List Size = " + b5.getAnswerListSize());
        System.out.println("The Question List Size = " + b5.getQuestionListSize());

        b5.setLists("is This a test?", "DUHH!!!");
        b5.setLists("adfadfad", "DUHH!!!");
        b5.setLists("adfadfad", "DUHH!!!");
        b5.setLists("adfadfad", "DUHH!!!");

        System.out.println("The Answer List Size = " + b5.getAnswerListSize());
        System.out.println("The Question List Size = " + b5.getQuestionListSize());

        qb.setupGui(b5);

    }
}



class QuizCard implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> mQuestionList = new ArrayList<String>();
    private ArrayList<String> mAnswerList = new ArrayList<String>();

    //public QuizCard(String question, String answer) {
    //  mQuestionList.add(question);
    //  mAnswerList.add(answer);

    //}

    final static String firstQuestion = "What class is used for writing to a text file?";
    final static String firstAnswer = "class FileWriter";

    public QuizCard() {
        //mQuestionList.clear();
        //mQuestionList.clear();
        //mQuestionList.add(0, "What class is used for writing to a text file?");
        //mAnswerList.add(0,"class FileWriter");

        mQuestionList.add(firstQuestion);
        mAnswerList.add(firstAnswer);

    }

    public void clearAnswers()
    {
        mAnswerList.clear();
    }

    public void clearQuestions()
    {
        mQuestionList.clear();
    }

    public void setLists(String q, String a) {
        mQuestionList.add(q);
        mAnswerList.add(a);

    }

    public String getQuestion(int q) {

        //if ((q > mQuestionList.size())) {
        //  q = 0;
        //}

        //return mQuestionList.get(q);
        return mQuestionList.get(q);
    }

    public String getAnswer(int a) 
    {
        //if ((a > mAnswerList.size())) {
        //  a = 0;
        //}
        //return mAnswerList.get(a);

        return mAnswerList.get(a);
    }

    public int getQuestionListSize() {
        return mQuestionList.size();
    }

    public int getAnswerListSize() {
        return mAnswerList.size();
    }

}

class QuizCardBuilder implements Serializable, ActionListener {
    private static final long serialVersionUID = 1L;
    //QuizCard b5 = new QuizCard();
    QuizCard qz;

    int list;
    JFrame frame;
    JPanel background;

    JTextArea areaN;
    JTextArea areaS;
    JButton buttonNext;
    JLabel labelN;
    JLabel labelS;
    JScrollPane scrollN;
    JScrollPane scrollS;

    public void setupGui(QuizCard qz) {
        this.qz = qz;
        frame = new JFrame("Gray Garrett LLC Presents: QUIZ CARD FLASH 1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        background = new JPanel();
        background.setBackground(Color.magenta);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        areaN = new JTextArea(10, 20);
        areaS = new JTextArea(10, 20);

        areaN.setText(qz.getQuestion(0));
        areaS.setText(qz.getAnswer(0));

        areaN.setLineWrap(true);
        areaS.setLineWrap(true);

        scrollN = new JScrollPane(areaN);
        scrollN.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollN.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollS = new JScrollPane(areaS);
        scrollS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        labelN = new JLabel("QUESTION");
        labelS = new JLabel("ANSWER");

        buttonNext = new JButton("NEXT");
        buttonNext.addActionListener(this);

        background.add(labelN);
        background.add(scrollN);
        background.add(labelS);
        background.add(scrollS);
        background.add(buttonNext);

        frame.getContentPane().add(BorderLayout.CENTER, background);

        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        areaN.setText("");
        areaS.setText("");

        list++;

        if (list >= qz.getQuestionListSize()) {
            list = 0;
        }

        // areaN.setText("");
        areaN.setText(qz.getQuestion(list));
        areaS.setText(qz.getAnswer(list));
    }

    class AnswerListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            for (int z = 0; z < qz.getQuestionListSize(); z++) {
                if (!areaN.equals(qz.getQuestion(z))) {
                    areaS.setText(" ");
                    areaS.setText("CUSTOM QUESTION HAS NOT BEEN SAVED!");
                }
            }

            areaS.setText("");
            areaS.setText(qz.getAnswer(list));

        }
    }
}