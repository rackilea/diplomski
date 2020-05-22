import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                LoginPane loginPane = new LoginPane();
                boolean authenticated = false;
                boolean exit = false;
                do {
                    int option = JOptionPane.showOptionDialog(null,
                                    loginPane,
                                    "login",
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    new Object[]{"Login", "Cancel"},
                                    "Login");
                    if (option == 0) {
                        // Authenticate
                        authenticated = true;
                    } else if (option == JOptionPane.CLOSED_OPTION || option == 1) {
                        exit = true;
                    }
                } while (!authenticated && !exit);
                if (authenticated) {
                    JFrame frame = new JFrame();
                    frame.add(new MainPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
        });
    }

    public class LoginPane extends JPanel {

        private JTextField userName;
        private JPasswordField password;

        public LoginPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;

            add(new JLabel("User name: "), gbc);
            gbc.gridy++;
            add(new JLabel("Password: "), gbc);

            gbc.gridx++;
            gbc.gridy = 0;

            userName = new JTextField(10);
            password = new JPasswordField(10);

            add(userName, gbc);
            gbc.gridy++;
            add(password, gbc);
        }

        public String getName() {
            return userName.getText();
        }

        public char[] getPassword() {
            return password.getPassword();
        }

    }

    public class MainPane extends JPanel {

        public MainPane() {
            setBorder(new EmptyBorder(50, 50, 50, 50));
            add(new JLabel("Super awesome app"));
        }

    }

}