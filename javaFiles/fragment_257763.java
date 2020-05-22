import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

public class QuestionAnswer {

    public static void main(String[] args) {
        new QuestionAnswer();
    }

    public QuestionAnswer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new QuestionsPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class QuestionsPane extends JPanel {

        public QuestionsPane() {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            final List<Question> questions = new ArrayList<>(3);
            questions.add(new Question("The color of a banana?", 
                            new Answer("Yellow"),
                            new Answer("Pink"),
                            new Answer("Blue"),
                            new Answer("Orange")
                    ));
            questions.add(new Question("The utimate question of life the universe and every thing?", 
                            new Answer("42"),
                            new Answer("Sleep"),
                            new Answer("Choclate"),
                            new Answer("1024"),
                            new Answer("Microsoft"),
                            new Answer("Apple")
                    ));
            questions.add(new Question("Who's your daddy?", 
                            new Answer("Darth Vadar"),
                            new Answer("Anikin Skywalker"),
                            new Answer("Yoda"),
                            new Answer("Mace Windo"),
                            new Answer("Chewbacca"),
                            new Answer("R2D2")
                    ));

            for (Question q : questions) {

                add(new QuestionAnswerPane(q), gbc);

            }

            gbc.weighty = 1;
            add(new JPanel(), gbc);
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;

            JButton submit = new JButton("Submit");
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Question q : questions) {
                        System.out.println(q.getText());
                        System.out.println("\t      Your answer was : " + q.getSelectedAnswer());
                        System.out.println("\tThe correct answer is : " + q.getCorrectAnswer());
                        System.out.println("\t              You are : " + (q.isCorrectAnswer() ? "Right" : "Wrong"));
                    }
                }
            });

            add(submit, gbc);

        }

    }

    public class QuestionAnswerPane extends JPanel {

        public QuestionAnswerPane(Question question) {

            List<Answer> answers = new ArrayList<>(question.getWrongAnswers());
            answers.add(question.getCorrectAnswer());

            Collections.shuffle(answers);

            setBorder(new TitledBorder(question.getText()));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            ButtonGroup bg = new ButtonGroup();
            for (Answer answer : answers) {

                JRadioButton rb = new JRadioButton(new AnswerAction(question, answer));
                bg.add(rb);
                add(rb, gbc);

            }
            gbc.weighty = 1;
            add(new JPanel(), gbc);

        }

    }

    public class AnswerAction extends AbstractAction {

        private final Question question;
        private final Answer answer;

        public AnswerAction(Question question, Answer answer) {
            this.question = question;
            this.answer = answer;
            putValue(NAME, answer.getText());
        }

        public Answer getAnswer() {
            return answer;
        }

        public Question getQuestion() {
            return question;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getQuestion().setSelectedAnswer(answer);
        }

    }

    public class Question {

        private Answer correctAnswer;
        private List<Answer> wrongAnswers;
        private Answer selectedAnswer;

        private String text;

        public Question(String text, Answer correct, Answer... wrong) {
            wrongAnswers = new ArrayList<>(Arrays.asList(wrong));
            correctAnswer = correct;
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public Answer getCorrectAnswer() {
            return correctAnswer;
        }

        public List<Answer> getWrongAnswers() {
            return Collections.unmodifiableList(wrongAnswers);
        }

        public Answer getSelectedAnswer() {
            return selectedAnswer;
        }

        public void setSelectedAnswer(Answer selectedAnswer) {
            this.selectedAnswer = selectedAnswer;
        }

        public boolean isCorrectAnswer() {
            Answer answer = getSelectedAnswer();
            Answer correct = getCorrectAnswer();
            return correct.equals(answer);
        }

        @Override
        public String toString() {
            return getText();
        }

    }

    public class Answer {

        private String text;

        public Answer(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return getText();
        }

    }

}