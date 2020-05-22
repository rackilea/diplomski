import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BobLogin extends JFrame implements ActionListener {

    // Declare all of the component variables.
    private JButton login;
    //Here is an issue fix!
    private JTextField usernameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);;
    private JLabel username;
    private JLabel password;
    private JFrame loginFrame;

    private String usernameText = "Username:";
    private int usernameColumns = 20;
    private String passwordText = "Password:";
    private int passwordColumns = 20;

    //Declare all of the constants.
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    //Login password and username.
    private static final String correctUsername = "Admin";
    private static final String correctPassword = "Password";

    //Constructor that calls initliaziation method when an object is created.
    public BobLogin() {
        initializeGUI();
    }

    //Sets up the login GUI.
    private void initializeGUI() {
        JButton login = new JButton("Login");
        JLabel username = new JLabel(usernameText);
        JLabel password = new JLabel(passwordText);
        JFrame loginFrame = new JFrame();
        JPanel loginPanel = new JPanel(new FlowLayout());
        loginPanel.add(username);
        loginPanel.add(usernameField);
        loginPanel.add(password);
        loginPanel.add(passwordField);
        loginPanel.add(login);
        login.addActionListener(this);
        loginFrame.add(loginPanel);
        // loginFrame.setSize(WIDTH, HEIGHT);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setResizable(false);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        //username.req

    }

    public static void main(String[] args) {
        BobLogin bobLogin = new BobLogin();
    }

    //What happens when the "Login" button is clicked.
    @Override
    public void actionPerformed(ActionEvent e) {
        String usernameResponse = usernameField.getText();
        //String passwordResponse = passwordField.getText();
        if(usernameResponse.equalsIgnoreCase("Admin")){
            System.out.println("Correct");
        }else{
            System.exit(0);
        }
    }

}