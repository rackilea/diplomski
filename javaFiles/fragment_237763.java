import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class GUI extends JFrame {
    JComboBox<String> comboBox;

    private JPanel cardPanel;

/*#################################################################################################################################################################
 *########################################################################Constructors#############################################################################
 *###############################################################################################################################################################*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Login Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private JPanel loginP;
    private JLabel titleL;
    private JLabel instructL;
    private JLabel usernameL;
    private JLabel passwordL;
    private JLabel loginL;
    private JButton studentB;
    private JButton lecturerB;
    private JTextField usernameTF;
    private JTextField passwordTF;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Add Question Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     private JPanel addQP;
    private JPanel addQP;
    private JLabel instructionsL;
    private JLabel txtL;
    private JLabel infoL;
    private JButton appendB;
    private JButton overwriteB;
    private JTextField pathTF;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Question Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private JPanel questionP;
    private JLabel qNumL;
    private JLabel groupL;
    private JLabel questionL;
    private JLabel opt1L;
    private JLabel opt2L;
    private JLabel opt3L;
    private JLabel opt4L;
    private JButton opt1B;
    private JButton opt2B;
    private JButton opt3B;
    private JButton opt4B;
    String qNumber = "3";
    String group = "JDBC";
    String question = "This is the question";
    String opt1 = "This is option 1";
    String opt2 = "This is option 2";
    String opt3 = "This is option 3";
    String opt4 = "This is option 4";
    String a = "a.";
    String b = "b.";
    String c = "c.";
    String d = "d.";
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Viewer Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private JPanel viewerP;
    private JLabel aL;
    private JLabel bL;
    private JLabel cL;
    private JLabel dL;
    private JButton nextB;
    private JButton closeB;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Select Question Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private JPanel selectQP;
    private JLabel instruct1L;
    private JLabel askL;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JButton viewB;
    private JButton startB;
    private JTextField numOfQTF;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Mark Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private JPanel markP;
    private JLabel percentageL;
    private JLabel outOfL;
    private JButton backB;
    private JButton logOutB;

    Connection con;
    Statement stmt;
    ResultSet rs;

/*#################################################################################################################################################################
 *#########################################################################Panels##################################################################################
 *###############################################################################################################################################################*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Login Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setSize(600, 400);
                gui.setResizable(true);
                gui.setVisible(true);
            }
        });
    }

    public GUI() {
        super("Tester");            
        loginP = new JPanel();
        GroupLayout loginPLayout = new GroupLayout(loginP);
        loginP.setLayout(loginPLayout);
        loginPLayout.setAutoCreateGaps(true);
        loginPLayout.setAutoCreateContainerGaps(true);

        Font font = new Font("Freestyle Script", Font.PLAIN,80);

        titleL = new JLabel("Tester");
        titleL.setFont(font);
        instructL = new JLabel("Please eneter your name and password and select your login type to login.");
        usernameL = new JLabel("Username:");
        passwordL = new JLabel("Password:");
        loginL = new JLabel("Login as");
        studentB = new JButton("Student");
        lecturerB = new JButton("Lecturer");
        usernameTF = new JTextField("", 100);
        passwordTF = new JTextField("", 100);

        studentB.addActionListener(new studentH());
        lecturerB.addActionListener(new lecturerH());

        loginPLayout.setHorizontalGroup(loginPLayout.createSequentialGroup()
            .addGroup(loginPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(usernameL)
                .addComponent(passwordL))
            .addGroup(loginPLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(titleL)
                .addComponent(instructL)
                .addComponent(usernameTF)
                .addComponent(passwordTF)
                .addComponent(loginL)
            .addGroup(loginPLayout.createSequentialGroup()
                .addComponent(studentB)
                .addComponent(lecturerB)))
        );

        loginPLayout.setVerticalGroup(loginPLayout.createSequentialGroup()
            .addComponent(titleL)
            .addComponent(instructL)
            .addGroup(loginPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(usernameL)
                .addComponent(usernameTF))
            .addGroup(loginPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(passwordL)
                .addComponent(passwordTF))
                .addComponent(loginL)
            .addGroup(loginPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(studentB)
                .addComponent(lecturerB))
        );

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Select Question Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        selectQP = new JPanel();
        GroupLayout selectQPLayout = new GroupLayout(selectQP);
        selectQP.setLayout(selectQPLayout);
        selectQPLayout.setAutoCreateGaps(true);
        selectQPLayout.setAutoCreateContainerGaps(true);

        String cat1 = "Collections";
        String cat2 = "Multithreading";
        String cat3 = "Networking";
        String cat4 = "JDBC";

        instruct1L = new JLabel("Select the groups of questions you would like to be tested on");
        askL = new JLabel("How many questions would you like?");
        checkBox1 = new JCheckBox(cat1);
        checkBox2 = new JCheckBox(cat2);
        checkBox3 = new JCheckBox(cat3);
        checkBox4 = new JCheckBox(cat4);
        viewB = new JButton("View Questions");
        startB = new JButton("Start Test");
        numOfQTF = new JTextField("", 100);

        viewB.addActionListener(new viewH());
        startB.addActionListener(new startH());

        selectQPLayout.setHorizontalGroup(selectQPLayout.createParallelGroup()
            .addComponent(instruct1L)
            .addComponent(checkBox1)
            .addComponent(checkBox2)
            .addComponent(checkBox3)
            .addComponent(checkBox4)
            .addComponent(askL)
            .addComponent(numOfQTF)
        .addGroup(selectQPLayout.createSequentialGroup()
            .addComponent(viewB)
            .addComponent(startB))
        );

        selectQPLayout.setVerticalGroup(selectQPLayout.createSequentialGroup()
            .addComponent(instruct1L)
            .addComponent(checkBox1)
            .addComponent(checkBox2)
            .addComponent(checkBox3)
            .addComponent(checkBox4)
            .addComponent(askL)
            .addComponent(numOfQTF)
            .addGroup(selectQPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(viewB)
                .addComponent(startB))
        );

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Add Question Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        addQP = new JPanel();
        GroupLayout addQPLayout = new GroupLayout(addQP);
        addQP.setLayout(addQPLayout);
        addQPLayout.setAutoCreateGaps(true);
        addQPLayout.setAutoCreateContainerGaps(true);

        instructionsL = new JLabel("Please enter the name of the file:");
        txtL = new JLabel(".txt");
        infoL = new JLabel("You will be logged out after the questions have been added.");
        appendB = new JButton("Append Questions");
        overwriteB = new JButton("Overwrite Questions");
        pathTF = new JTextField("", 100);

        appendB.addActionListener(new appendH());
        overwriteB.addActionListener(new overwriteH());

        addQPLayout.setHorizontalGroup(addQPLayout.createSequentialGroup()
        .addGroup(addQPLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(instructionsL)
            .addGroup(addQPLayout.createSequentialGroup()
                .addComponent(pathTF)
                .addComponent(txtL))
            .addComponent(infoL)
            .addGroup(addQPLayout.createSequentialGroup()
                .addComponent(appendB)
                .addComponent(overwriteB)))
        );

        addQPLayout.setVerticalGroup(addQPLayout.createSequentialGroup()
            .addComponent(instructionsL)
            .addGroup(addQPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(pathTF)
                .addComponent(txtL))
            .addComponent(infoL)
            .addGroup(addQPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(appendB)
                .addComponent(overwriteB))
        );

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Question Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        qNumL = new JLabel("Question Number: " + qNumber);
        groupL = new JLabel("Group: " + group);
        questionL = new JLabel(question);
        opt1L = new JLabel(opt1);
        opt2L = new JLabel(opt2);
        opt3L = new JLabel(opt3);
        opt4L = new JLabel(opt4);
        opt1B = new JButton("A");
        opt2B = new JButton("B");
        opt3B = new JButton("C");
        opt4B = new JButton("D");

        questionP = new JPanel();
//            add(questionP);
        GroupLayout questionPLayout = new GroupLayout(questionP);
        questionP.setLayout(questionPLayout);
        questionPLayout.setAutoCreateGaps(true);
        questionPLayout.setAutoCreateContainerGaps(true);

        optH handler = new optH();
        opt1B.addActionListener(handler);
        //opt2B.addActionListener(handler);
        //opt3B.addActionListener(handler);
        //opt4B.addActionListener(handler);

        questionPLayout.setHorizontalGroup(questionPLayout.createSequentialGroup()
            .addGroup(questionPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(qNumL)
                .addComponent(questionL)
                .addComponent(opt1B)
                .addComponent(opt2B)
                .addComponent(opt3B)
                .addComponent(opt4B))
            .addGroup(questionPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(opt1L)
                .addComponent(opt2L)
                .addComponent(opt3L)
                .addComponent(opt4L))
            .addGroup(questionPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(groupL))
        );

        questionPLayout.setVerticalGroup(questionPLayout.createSequentialGroup()
            .addGroup(questionPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(qNumL)
                .addComponent(groupL))
            .addComponent(questionL)
            .addGroup(questionPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(opt1B)
                .addComponent(opt1L))
            .addGroup(questionPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(opt2B)
                .addComponent(opt2L))
            .addGroup(questionPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(opt3B)
                .addComponent(opt3L))
            .addGroup(questionPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(opt4B)
                .addComponent(opt4L))
        );

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Viewer Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        qNumL = new JLabel("Question Number: " + qNumber);
        groupL = new JLabel("Group: " + group);
        questionL = new JLabel(question);
        aL = new JLabel("A");
        bL = new JLabel("B");
        cL = new JLabel("C");
        dL = new JLabel("D");
        opt1L = new JLabel(opt1);
        opt2L = new JLabel(opt2);
        opt3L = new JLabel(opt3);
        opt4L = new JLabel(opt4);
        nextB = new JButton("Next");
        closeB = new JButton("Close");

        viewerP = new JPanel();
        GroupLayout viewerPLayout = new GroupLayout(viewerP);
        viewerP.setLayout(viewerPLayout);
        viewerPLayout.setAutoCreateGaps(true);
        viewerPLayout.setAutoCreateContainerGaps(true);

        viewerPLayout.setHorizontalGroup(viewerPLayout.createSequentialGroup()
            .addGroup(viewerPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(qNumL)
                .addComponent(questionL)
                .addComponent(aL)
                .addComponent(bL)
                .addComponent(cL)
                .addComponent(dL))
            .addGroup(viewerPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(opt1L)
                .addComponent(opt2L)
                .addComponent(opt3L)
                .addComponent(opt4L))
            .addGroup(viewerPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(groupL)
                .addGroup(viewerPLayout.createSequentialGroup()
                    .addComponent(nextB)
                    .addComponent(closeB)))
        );

        viewerPLayout.setVerticalGroup(viewerPLayout.createSequentialGroup()
            .addGroup(viewerPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(qNumL)
                .addComponent(groupL))
            .addComponent(questionL)
            .addGroup(viewerPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(aL)
                .addComponent(opt1L))
            .addGroup(viewerPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(bL)
                .addComponent(opt2L))
            .addGroup(viewerPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cL)
                .addComponent(opt3L))
            .addGroup(viewerPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(dL)
                .addComponent(opt4L))
            .addGroup(viewerPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nextB)
                .addComponent(closeB))
        );

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Mark Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        markP = new JPanel();
        GroupLayout markPLayout = new GroupLayout(markP);
        markP.setLayout(markPLayout);
        markPLayout.setAutoCreateGaps(true);
        markPLayout.setAutoCreateContainerGaps(true);

        int percentage = 90;
        int correct = 9;
        int total = 10;

        percentageL = new JLabel("You scored: " + percentage + "%");
        outOfL = new JLabel("You have " + correct + " corret answers out of a possible " + total);
        backB = new JButton("Back to Group Selection");
        logOutB = new JButton("Log Out");

        backB.addActionListener(new backH());
        logOutB.addActionListener(new logOutH());

        markPLayout.setHorizontalGroup(markPLayout.createParallelGroup()
            .addComponent(percentageL)
            .addComponent(outOfL)
        .addGroup(markPLayout.createSequentialGroup()
            .addComponent(backB)
            .addComponent(logOutB))
        );

        markPLayout.setVerticalGroup(markPLayout.createSequentialGroup()
            .addComponent(percentageL)
                .addComponent(outOfL)
            .addGroup(markPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(backB)
                .addComponent(logOutB))
        );

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Card Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        cardPanel = new JPanel(new CardLayout(0,0));
        JPanel[] cards = new JPanel[6];
        String[] titles = new String[6];
        cards[0] = loginP;
        cards[1] = selectQP;
        cards[2] = addQP;
        cards[3] = questionP;
        cards[4] = viewerP;
        cards[5] = markP;
        titles[0] = "loginP";
        titles[1] = "selectQP";
        titles[2] = "addQP";
        titles[3] = "questionP";
        titles[4] = "viewerP";
        titles[5] = "markP";
        for(int i = 0; i < cards.length; i++) {
            cardPanel.add(cards[i], titles[i]);
        }

        //You can remove this once you are satisfied card layout works with your buttons - this is just for the combobox I added
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
        comboBox = new JComboBox<>(titles);
        comboBox.addActionListener(new CardListener());
        add(comboBox, BorderLayout.NORTH);
        //Add this back in once you remove the rest
//            add(cardPanel);

        pack();
    }

    //You can remove this once you are satisfied card layout works with your buttons - this is just for the combobox I added
    private class CardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout c1 = (CardLayout)(cardPanel.getLayout());
            c1.show(cardPanel, (String)comboBox.getSelectedItem());
        }
    }

/*#################################################################################################################################################################
 *#####################################################################Action Listeners############################################################################
 *###############################################################################################################################################################*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Login Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private class studentH implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Student stu = new Student();

            String username = usernameTF.getText();
            String password = passwordTF.getText();
            boolean correct = stu.Student(username, password);
            if(correct == true) {
                changeCard("selectQP");
            }
            else {
                JOptionPane.showMessageDialog(null, "You have entered incorect details. Please try again", "Incorrect Details", JOptionPane.ERROR_MESSAGE);
                usernameTF.setText("");
                passwordTF.setText("");
            }
        }
    }

    private class lecturerH implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Lecturer lect = new Lecturer();

            String username = usernameTF.getText();
            String password = passwordTF.getText();
            boolean correct = lect.Lecturer(username, password);
            if(correct == true) {
                changeCard("addQP");
            }
            else {
                JOptionPane.showMessageDialog(null, "You have entered incorect details. Please try again", "Incorrect Details", JOptionPane.ERROR_MESSAGE);
                usernameTF.setText("");
                passwordTF.setText("");
            }
        }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Add Question Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private class appendH implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            //Append appen = new Append();
            String path = pathTF.getText();
            //appen.Append(path);
        }
    }

    private class overwriteH implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
//            Overwrite over = new Overwrite();
        }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Question Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private class optH implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ) {

        }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Select Question Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private class viewH implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ) {

        }
    }

    private class startH implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ) {

        }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Mark Panel ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private class backH implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ) {

        }
    }

    private class logOutH implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ) {

        }
    }

    private void changeCard(String newCardName) {
       CardLayout c1 = (CardLayout)(cardPanel.getLayout());
       c1.show(cardPanel, newCardName);
    }
}