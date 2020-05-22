import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLogin {

    public static void main(String[] args) {
        new TestLogin();
    }

    public TestLogin() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JDialog frame = new JDialog((Frame) null, "Login", true);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                System.exit(0);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("User Name:"), gbc);
            gbc.gridy++;
            add(new JLabel("Password:"), gbc);
            gbc.gridx++;
            gbc.gridy = 0;
            add(new JTextField(10), gbc);
            gbc.gridy++;
            add(new JPasswordField(10), gbc);

            JButton okay = new JButton("Okay");
            JButton cancel = new JButton("Cancel");

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            add(okay, gbc);
            gbc.gridx++;
            add(cancel, gbc);

            okay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setFormEnabled(false);
                    new LoginWorker().execute();
                }
            });

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.windowForComponent((Component) e.getSource()).dispose();
                }
            });
        }

        protected void setFormEnabled(boolean enabled) {
            for (Component comp : getComponents()) {
                comp.setEnabled(enabled);
            }
        }

        protected void loginSuccessful() {
            SwingUtilities.windowForComponent(this).dispose();
        }

        protected void loginFailed() {
            JOptionPane.showMessageDialog(this, "Login failed", "Fail", JOptionPane.ERROR_MESSAGE);
            setFormEnabled(true);
        }

        public class LoginWorker extends SwingWorker<Boolean, Void> {

            @Override
            protected Boolean doInBackground() throws Exception {
                boolean login = false;
                Thread.sleep(5000);
                login = (int) Math.round(Math.random() * 1) == 0 ? false : true;
                return login;
            }

            @Override
            protected void done() {
                try {
                    Boolean login = get();
                    if (login) {
                        loginSuccessful();
                    } else {
                        loginFailed();
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    loginFailed();
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                    loginFailed();
                }
            }
        }
    }
}