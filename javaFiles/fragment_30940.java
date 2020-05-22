import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingTest extends JFrame {

    JButton loginButton;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton editButton;
    JButton createButton;
    JButton logoutButton;

    private void setLoginFieldVisibility(boolean val) {
        loginButton.setVisible(val);
        usernameField.setVisible(val);
        passwordField.setVisible(val);
        invalidate();
    }

    private void setFixtureFieldVisibility(boolean val) {
        editButton.setVisible(val);
        createButton.setVisible(val);
        logoutButton.setVisible(val);
        invalidate();
    }

    private void initialize() {
        setLayout(null);
        loginButton = new JButton("Login");
        loginButton.setBounds(80, 250, 70, 30);
        add(loginButton);
        usernameField = new JTextField(15);
        usernameField.setBounds(60, 110, 130, 30);
        add(usernameField);
        passwordField = new JPasswordField(15);
        passwordField.setBounds(60, 150, 130, 30);
        add(passwordField);        
        editButton = new JButton("Edit");
        editButton.setBounds(10, 10, 80, 30);
        add(editButton);
        createButton = new JButton(("Create"));
        createButton.setBounds(145, 10, 80, 30);
        add(createButton);
        logoutButton = new JButton(("Log Out"));
        logoutButton.setBounds(10, 350, 80, 30);
        add(logoutButton);

        setFixtureFieldVisibility(false);

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setLoginFieldVisibility(false);
                setFixtureFieldVisibility(true);
            }
        });

        logoutButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setLoginFieldVisibility(true);
                setFixtureFieldVisibility(false);
            }
        });
    }

    public static void main(String[] args) {

        SwingTest window = new SwingTest();

        window.setTitle("PE Fixtures v1.0");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(250, 430);
        window.initialize();
        window.setResizable(false);
        window.getContentPane().setBackground(new Color(53, 56, 64));
        window.setVisible(true);
    }
}