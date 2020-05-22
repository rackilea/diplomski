import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LogInTest {

    public static void main(String[] args) {
        new LogInTest();
    }

    public LogInTest() {
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
                frame.add(new LoginPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class LoginPanel extends JPanel {

        private JTextField userfield = new JTextField(10);
        private JPasswordField passfield = new JPasswordField(10);
        private JButton login = new JButton("Login");
        private JButton create = new JButton("Create Account");

        public LoginPanel() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.weightx = 1;
            gbc.gridx = 2;
            gbc.anchor = GridBagConstraints.EAST;
            JLabel label = new JLabel("Username: ");
            add(label, gbc);

            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 3;
            gbc.gridwidth = 2;
            add(userfield, gbc);

            gbc.gridy = 1;
            add(passfield, gbc);

            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx = 2;
            label = new JLabel("Password: ");
            add(label, gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridy = 2;
            gbc.gridx = 1;
            gbc.gridwidth = 5;
            add(new JSeparator(JSeparator.HORIZONTAL), gbc);
        }
    }

}