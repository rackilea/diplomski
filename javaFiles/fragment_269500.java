package ems;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField usernameField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        this.setTitle("Login");
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(112, 116, 74, 16);
        this.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(112, 165, 74, 16);
        this.getContentPane().add(lblPassword);

        usernameField = new JTextField();
        usernameField.setBounds(198, 110, 134, 28);
        this.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(198, 159, 134, 28);
        this.getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String uname = usernameField.getText();
                String pword = passwordField.getText();

                if (uname.equals("test") && pword.equals("test")){
                    JOptionPane.showMessageDialog(Login.this, "Login successful.");
                    Login.this.setVisible(false);
                    Menu menu = new Menu ();
                    menu.setVisible (true);

                }else{
                    JOptionPane.showMessageDialog(Login.this, "Login unsuccessful.");
                }
            }
        });
        btnLogin.setBounds(238, 210, 90, 30);
        this.getContentPane().add(btnLogin);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(108, 210, 90, 30);
        this.getContentPane().add(btnExit);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(91, 86, 258, 163);
        this.getContentPane().add(panel);

        JLabel lblLoginToThe = new JLabel("LOGIN TO THE ELECTRICITY MONITORING SYSTEM");
        lblLoginToThe.setForeground(new Color(255, 255, 255));
        lblLoginToThe.setFont(new Font("Arial", Font.BOLD, 16));
        lblLoginToThe.setBounds(26, 23, 418, 16);
        this.getContentPane().add(lblLoginToThe);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(46, 139, 87));
        panel_1.setBounds(0, 0, 450, 63);
        this.getContentPane().add(panel_1);
    }
}