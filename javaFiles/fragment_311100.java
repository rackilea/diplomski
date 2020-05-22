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