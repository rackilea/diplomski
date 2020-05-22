public class Main2 {

    public class Questions {

        String Question;
        String userAns;
        String realAns;
    }

    static int count = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Screen");
        frame.setSize(2500, 2500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setSize(2500, 2500);
        panel.setLayout(null);
        //panel.setBackground(Color.red);

        Question[] questions = new Question[3];
        System.out.println(questions.length);
        Question q1 = new Question();
        q1.Question = "1) What is your Name?";
        q1.A = "Bob";
        q1.B = "Billy";
        q1.C = "Joe";
        q1.D = "Jill";
        questions[0] = q1;

        Question q2 = new Question();
        q2.Question = "2) What is your Age?";
        q2.A = "5";
        q2.B = "69";
        q2.C = "21";
        q2.D = "12";
        questions[1] = q2;

        Question q3 = new Question();
        q3.Question = "3) When Is your Birthday?";
        q3.A = "May";
        q3.B = "Jan";
        q3.C = "Apr";
        q3.D = "Aug";
        questions[2] = q3;

        //When this question is added the code breaks down
        JLabel Question = new JLabel(questions[0].Question);
        Question.setBounds(50, 0, 1500, 50);
        panel.add(Question);
        Question.setFont(new Font(Question.getFont().getName(), Font.PLAIN, 25));
        Question.setVisible(true);

        JLabel incorrectAnswerLabel = new JLabel("Incorrect Answer! Try Again");
        incorrectAnswerLabel.setBounds(300, 0, 1000, 500);
        panel.add(incorrectAnswerLabel);
        incorrectAnswerLabel.setVisible(false);
        incorrectAnswerLabel.setFont(new Font(incorrectAnswerLabel.getFont().getName(), Font.BOLD, 46));
        incorrectAnswerLabel.setForeground(Color.RED);

        JLabel correctAnswerLabel = new JLabel("Correct Answer! Good Job");
        correctAnswerLabel.setBounds(300, 0, 1000, 500);
        panel.add(correctAnswerLabel);
        correctAnswerLabel.setVisible(false);
        correctAnswerLabel.setFont(new Font(correctAnswerLabel.getFont().getName(), Font.BOLD, 46));
        correctAnswerLabel.setForeground(Color.GREEN);

        JButton submitButton = new JButton();
        submitButton.setBounds(50, 250, 150, 50);
        submitButton.setText("Submit");
        panel.add(submitButton);
        submitButton.setVisible(true);

        JRadioButton OptionA = new JRadioButton(questions[0].A);
        OptionA.setBounds(50, 50, 100, 50);
        panel.add(OptionA);
        OptionA.setVisible(true);

        JRadioButton OptionB = new JRadioButton(questions[0].B);
        OptionB.setBounds(50, 100, 100, 50);
        panel.add(OptionB);
        OptionB.setVisible(true);

        JRadioButton OptionC = new JRadioButton(questions[0].C);
        OptionC.setBounds(50, 150, 100, 50);
        panel.add(OptionC);
        OptionC.setVisible(true);

        JRadioButton OptionD = new JRadioButton(questions[0].D);
        OptionD.setBounds(50, 200, 100, 50);
        panel.add(OptionD);
        OptionD.setVisible(true);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(OptionA);
        radioGroup.add(OptionB);
        radioGroup.add(OptionC);
        radioGroup.add(OptionD);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (submitButton.getText().equals("Submit")) {

                    if (OptionA.isSelected()) {
                        submitButton.setText("Next Question");
                        correctAnswerLabel.setVisible(true);

                    } else {
                        incorrectAnswerLabel.setVisible(true);
                    }
                } else {
                    correctAnswerLabel.setVisible(false);
                    submitButton.setText("Submit");

                    if(count < questions.length-1){
                        count = count+1;
                    }
                    Question q = questions[count];
                    Question.setText(q.Question);
                    setAnswers(q.A, q.B, q.C, q.D, OptionA, OptionB, OptionC, OptionD);
                }
            }

        });

    }

    static void setAnswers(String A, String B, String C, String D, JRadioButton a, JRadioButton b, JRadioButton c, JRadioButton d) {
        List<String> answers = Arrays.asList(A, B, C, D);
        Collections.shuffle(answers);
        a.setText(answers.get(0));
        b.setText(answers.get(1));
        c.setText(answers.get(2));
        d.setText(answers.get(3));
    }

}