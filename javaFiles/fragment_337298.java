import java.awt.BorderLayout;
import javax.swing.*;

public class NamePrompt extends JFrame{

    private static final long serialVersionUID = 1L;

    String name;

    public NamePrompt(){

        setLayout(new BorderLayout());

        JLabel enterYourName = new JLabel("Enter Your Name Here:");
        JTextField textBoxToEnterName = new JTextField(21);
        //textBoxToEnterName.setSize(40, 10);
        JPanel panelTop = new JPanel();
        panelTop.add(enterYourName);
        panelTop.add(textBoxToEnterName);

        JButton submit = new JButton("Submit");
        //submit.addActionListener(new SubmitButton());
        JPanel panelBottom = new JPanel();
        panelBottom.add(submit);

        //Add panelTop to JFrame
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        //JFrame set-up
        setTitle("Name Prompt Program");
        //setSize(300, 150);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        NamePrompt promptForName = new NamePrompt();
        promptForName.setVisible(true);
    }
}