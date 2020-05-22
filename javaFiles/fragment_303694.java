import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLogin {
    private JFrame frame;
    private boolean authenticated;
    private JTextField login;
    private JPasswordField password;

    protected void initUI() {
        frame = new JFrame(TestLogin.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    protected void showLoginDialog() {
        authenticated = false;
        final JDialog dialog = new JDialog(frame, "Please provide your credentials");
        dialog.setModal(true);
        JPanel panel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel();
        login = new JTextField(40);
        password = new JPasswordField(20);
        JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Password:");
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Here perform authentication and set authentication flag to appropriate value
                authenticated = true;
                if (authenticated) {
                    setUpFrame();
                    dialog.dispose();
                }
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (!authenticated) {
                    System.exit(0);
                }
            }
        });
        dialog.getRootPane().setDefaultButton(ok);
        buttonPanel.add(ok);
        buttonPanel.add(cancel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(loginLabel, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        panel.add(login, gbc);
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        panel.add(passwordLabel, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        panel.add(password, gbc);
        panel.add(buttonPanel, gbc);
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        while (!authenticated) {
            dialog.setVisible(true);
        }
    }

    protected void setUpFrame() {
        frame.add(new JLabel("Successfully authenticated"));
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestLogin testLogin = new TestLogin();
                testLogin.initUI();
                testLogin.showLoginDialog();
            }

        });
    }

}