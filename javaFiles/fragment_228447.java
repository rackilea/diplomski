public class ChangePasswordPane extends JPanel {
    private JPasswordField oldPassword;
    private JPasswordField newPassword;

    public ChangePasswordPane() {
        setLayout(new GridBagLayout());
        oldPassword = new JPasswordField(20);
        newPassword = new JPasswordField(20);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Old password: "), gbc);
        gbc.gridy++;
        add(new JLabel("New password: "), gbc);

        gbc.gridx++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        add(oldPassword, gbc);
        gbc.gridy++;
        add(newPassword, gbc);
    }

    public char[] getOldPassword() {
        return oldPassword.getPassword();
    }

    public char[] getNewPassword() {
        return newPassword.getPassword();
    }
}