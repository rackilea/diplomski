public class CredentialsPane extends JPanel implements CredentialsView {

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

    public void setCredentialsViewController(CredentialsViewController controller){
        this.controller = controller;
    }

}