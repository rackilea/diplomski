import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class StateMachine extends JPanel {
    private static final String INITIAL_TITLE = "Please enter your next 8 bits. "
            + "Do not enter more than 8 bits.\n"
            + "Press Enter when done";
    private static final String ARE_YOU_FINISHED = "Are you finished entering streams?";
    private static final String YES = "Yes";
    private static final String ENTER = "Enter";
    private static final String NO = "No";
    private static int GAP = 8;
    private static final int COLUMNS = 30;

    // this is a JTextArea built to look like a JLabel
    private JTextArea topTextArea = new JTextArea(2, COLUMNS);
    private JTextField dataEntryField = new JTextField(COLUMNS);
    private JButton yesEnterButton = new JButton(ENTER);
    private JButton noButton = new JButton(NO);
    private boolean enteringData = true;
    private boolean dataValidYet = false;

    public StateMachine() {
        yesEnterButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                yesEnterButtonActionPerfromed(e);
            }
        });

        noButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                noButtonActionPerfromed(e);
            }
        });

        topTextArea.setWrapStyleWord(true);
        topTextArea.setLineWrap(true);
        topTextArea.setFocusable(false);
        topTextArea.setEditable(false);
        topTextArea.setOpaque(false);
        topTextArea.setText(INITIAL_TITLE);

        JPanel innerButtonPanel = new JPanel(new GridLayout(1, 0, GAP, 0));
        innerButtonPanel.add(yesEnterButton);
        innerButtonPanel.add(noButton);
        JPanel outerButtonPanel = new JPanel();
        outerButtonPanel.add(innerButtonPanel);

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BorderLayout(GAP, GAP));
        add(topTextArea, BorderLayout.PAGE_START);
        add(dataEntryField, BorderLayout.CENTER);
        add(outerButtonPanel, BorderLayout.PAGE_END);
    }

    protected void noButtonActionPerfromed(ActionEvent e) {
        // TODO depending on state of enteringData and dataValidYet booleans
        // change text in buttons, do things with JTextField data
        // set state of enteringData and dataValidYet booleans

        if (enteringData) {
            // a no press is meaningless if entering data
            return;
        }

        // .... more

    }

    private void yesEnterButtonActionPerfromed(ActionEvent e) {
        // TODO depending on state of enteringData and dataValidYet booleans
        // change text in buttons, do things with JTextField data
        // set state of enteringData and dataValidYet booleans

        if (enteringData) {
            topTextArea.setText(ARE_YOU_FINISHED);
            yesEnterButton.setText(YES);
            yesEnterButton.setActionCommand(YES);
            enteringData = false;
            return;
        }
        // .... more

    }

    private static void createAndShowGui() {
        StateMachine mainPanel = new StateMachine();

        JFrame frame = new JFrame("State Machine");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}