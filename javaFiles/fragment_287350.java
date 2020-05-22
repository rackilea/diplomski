final JTextField username = new JTextField();
JTextField password = new JPasswordField();
JTextField prefix = new JTextField();
JPanel gridLayout = new JPanel(new GridLayout(6, 1));
gridLayout.add(new JLabel("Username:"));
gridLayout.add(username);
gridLayout.add(new JLabel("Password:"));
gridLayout.add(password);
gridLayout.add(new JLabel("Prefix:"));
gridLayout.add(prefix);

username.addAncestorListener(new AncestorListener() {
    @Override
    public void ancestorRemoved(AncestorEvent pEvent) {
    }

    @Override
    public void ancestorMoved(AncestorEvent pEvent) {
    }

    @Override
    public void ancestorAdded(AncestorEvent pEvent) {
        // TextField is added to its parent => request focus in Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                username.requestFocusInWindow();
            }
        });
    }
});

int option = JOptionPane.showConfirmDialog(null, gridLayout, "Login",
    JOptionPane.OK_CANCEL_OPTION);