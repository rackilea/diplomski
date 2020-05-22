import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import sun.net.www.protocol.http.HttpURLConnection;

public class Test {

    protected static final Random AUTHENTICATION_ORACLE = new Random();

    public static void main(String[] args) {
        new Test();
    }

    public interface CredentialsView {
        public String getUserName();
        public char[] getPassword();
        public void willAuthenticate();
        public void authenticationFailed();
        public void authenticationSucceeded();
        public CredentialsViewController getCredentialsViewController();
    }

    public interface CredentialsViewController {
        public void credientialsDidChange(CredentialsView view);
    }

    public interface LoginView {
        public CredentialsView getCredentialsView();
        public void willAuthenticate();
        public void authenticationFailed();
        public void authenticationSucceeded();
        public void dismissView();
        public LoginViewController getLoginViewController();
    }

    public interface LoginViewController {
        public void authenticationWasRequested(LoginView view);
        public void loginWasCancelled(LoginView view);
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

                LoginViewController controller = new LoginViewController() {

                    @Override
                    public void authenticationWasRequested(LoginView view) {
                        view.willAuthenticate();
                        LoginAuthenticator authenticator = new LoginAuthenticator(view);
                        authenticator.authenticate();
                    }

                    @Override
                    public void loginWasCancelled(LoginView view) {

                        view.dismissView();

                    }
                };

                if (LoginPane.showLoginDialog(controller)) {

                    System.out.println("You shell pass");

                } else {

                    System.out.println("You shell not pass");

                }

                System.exit(0);

            }
        });
    }

    public class LoginAuthenticator {

        private LoginView view;

        public LoginAuthenticator(LoginView view) {
            this.view = view;
        }

        public void authenticate() {

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            if (AUTHENTICATION_ORACLE.nextBoolean()) {
                                view.authenticationSucceeded();
                                view.dismissView();
                            } else {
                                view.authenticationFailed();
                            }
                        }
                    });
                }
            });
            t.start();

        }

    }

    public static class LoginPane extends JPanel implements LoginView, CredentialsViewController {

        private LoginViewController controller;
        private CredentialsPane credientialsView;

        private JButton btnAuthenticate;
        private JButton btnCancel;

        private boolean wasAuthenticated;

        public LoginPane(LoginViewController controller) {
            setLoginViewController(controller);
            setLayout(new BorderLayout());
            setBorder(new EmptyBorder(8, 8, 8, 8));

            btnAuthenticate = new JButton("Login");
            btnCancel = new JButton("Cancel");

            JPanel buttons = new JPanel();
            buttons.add(btnAuthenticate);
            buttons.add(btnCancel);

            add(buttons, BorderLayout.SOUTH);

            credientialsView = new CredentialsPane(this);
            add(credientialsView);

            btnAuthenticate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getLoginViewController().authenticationWasRequested(LoginPane.this);
                }
            });
            btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getLoginViewController().loginWasCancelled(LoginPane.this);
                    // I did think about calling dispose here,
                    // but's not really the the job of the cancel button to decide what should happen here...
                }
            });

            validateCreientials();

        }

        public static boolean showLoginDialog(LoginViewController controller) {

            final LoginPane pane = new LoginPane(controller);

            JDialog dialog = new JDialog();
            dialog.setTitle("Login");
            dialog.setModal(true);
            dialog.add(pane);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    pane.getLoginViewController().loginWasCancelled(pane);
                }
            });
            dialog.setVisible(true);

            return pane.wasAuthenticated();

        }

        public boolean wasAuthenticated() {
            return wasAuthenticated;
        }

        public void validateCreientials() {

            CredentialsView view = getCredentialsView();
            String userName = view.getUserName();
            char[] password = view.getPassword();
            if ((userName != null && userName.trim().length() > 0) && (password != null && password.length > 0)) {

                btnAuthenticate.setEnabled(true);

            } else {

                btnAuthenticate.setEnabled(false);

            }

        }

        @Override
        public void dismissView() {
            SwingUtilities.windowForComponent(this).dispose();
        }

        @Override
        public CredentialsView getCredentialsView() {
            return credientialsView;
        }

        @Override
        public void willAuthenticate() {
            getCredentialsView().willAuthenticate();
            btnAuthenticate.setEnabled(false);
        }

        @Override
        public void authenticationFailed() {
            getCredentialsView().authenticationFailed();
            validateCreientials();
            wasAuthenticated = false;
        }

        @Override
        public void authenticationSucceeded() {
            getCredentialsView().authenticationSucceeded();
            validateCreientials();
            wasAuthenticated = true;
        }

        public LoginViewController getLoginViewController() {
            return controller;
        }

        public void setLoginViewController(LoginViewController controller) {
            this.controller = controller;
        }

        @Override
        public void credientialsDidChange(CredentialsView view) {
            validateCreientials();
        }

    }

    public static class CredentialsPane extends JPanel implements CredentialsView {

        private CredentialsViewController controller;

        private JTextField userNameField;
        private JPasswordField passwordField;

        public CredentialsPane(CredentialsViewController controller) {
            setCredentialsViewController(controller);
            setLayout(new GridBagLayout());
            userNameField = new JTextField(20);
            passwordField = new JPasswordField(20);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(2, 2, 2, 2);
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel("Username: "), gbc);

            gbc.gridy++;
            add(new JLabel("Password: "), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(userNameField, gbc);
            gbc.gridy++;
            add(passwordField, gbc);

            DocumentListener listener = new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    getCredentialsViewController().credientialsDidChange(CredentialsPane.this);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    getCredentialsViewController().credientialsDidChange(CredentialsPane.this);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    getCredentialsViewController().credientialsDidChange(CredentialsPane.this);
                }
            };

            userNameField.getDocument().addDocumentListener(listener);
            passwordField.getDocument().addDocumentListener(listener);

        }

        @Override
        public CredentialsViewController getCredentialsViewController() {
            return controller;
        }

        @Override
        public String getUserName() {
            return userNameField.getText();
        }

        @Override
        public char[] getPassword() {
            return passwordField.getPassword();
        }

        @Override
        public void willAuthenticate() {
            userNameField.setEnabled(false);
            passwordField.setEnabled(false);
        }

        @Override
        public void authenticationFailed() {
            userNameField.setEnabled(true);
            passwordField.setEnabled(true);

            userNameField.requestFocusInWindow();
            userNameField.selectAll();

            JOptionPane.showMessageDialog(this, "Authentication has failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

        @Override
        public void authenticationSucceeded() {
            // Really don't care, but you might want to stop animation, for example...
        }

        public void setCredentialsViewController(CredentialsViewController controller) {
            this.controller = controller;
        }

    }

}