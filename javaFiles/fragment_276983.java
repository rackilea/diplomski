import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ExampleGame {

    public static void main(String[] args) {
        new ExampleGame();
    }

    public ExampleGame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                LoginPane pane = new LoginPane();
                int result = JOptionPane.showOptionDialog(null, pane, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Login", "Cancel"}, 0);
                if (result == 0) {

                    User user = pane.getUser();
                    // Perform the login...

                }

            }
        });
    }

    public class LoginPane extends JPanel {

        private JTextField userName;
        private JPasswordField password;

        public LoginPane() {

            userName = new JTextField(10);
            password = new JPasswordField(10);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel("Username:"), gbc);

            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(userName, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            add(new JLabel("Password:"), gbc);

            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(password, gbc);

        }

        public User getUser() {

            return new User(userName.getText(), password.getPassword());

        }

    }

    public class User {

        private String name;
        private char[] password;

        public User(String name, char[] password) {
            this.name = name;
            this.password = password;
        }

    }

}