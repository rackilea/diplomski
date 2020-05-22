public class TestPane extends JPanel {

    // This is cheat for demonstration purposes, please don't do this
    // in production
    private char[] password = "banana".toCharArray();

    public TestPane() {
        setLayout(new GridBagLayout());
        JButton btn = new JButton("Change password");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePasswordPane pane = new ChangePasswordPane();
                switch (JOptionPane.showConfirmDialog(TestPane.this, pane, "Change Password", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION)) {
                    case JOptionPane.OK_OPTION:
                        char[] oldPassword = pane.getOldPassword();
                        if (Arrays.equals(password, oldPassword)) {
                            password = pane.getNewPassword();
                            JOptionPane.showMessageDialog(TestPane.this, "Password was changed");
                        } else {
                            JOptionPane.showMessageDialog(TestPane.this, "Password mismatch, your old password does not match your current password");
                        }
                        break;
                }
            }
        });

        add(btn);
    }

}