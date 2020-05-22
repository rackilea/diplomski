public class HistoryPane extends JPanel {

    private final JTextField txtRole;
    private final JTextField txtDuration;
    private final JTextField txtEmployer;

    private final JButton removeButton;

    private EmployeeHistory history;

    public HistoryPane(EmployeeHistory history) {
        // This is what you should use when you want to populate
        // the view or properties of the UI are changed
        this.history = history;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblRoleHeld = new JLabel("Role Held:");
        add(lblRoleHeld, gbc);

        gbc.gridx++;
        txtRole = new JTextField();
        txtRole.setText("role");
        add(txtRole, gbc);
        txtRole.setColumns(10);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblDuration = new JLabel("Duration:");
        add(lblDuration, gbc);

        gbc.gridx++;
        txtDuration = new JTextField();
        txtDuration.setText("duration");
        add(txtDuration, gbc);
        txtDuration.setColumns(10);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblEmployer = new JLabel("Employer:");
        add(lblEmployer, gbc);

        gbc.gridx++;
        txtEmployer = new JTextField();
        txtEmployer.setText("employer");
        add(txtEmployer, gbc);
        txtEmployer.setColumns(10);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        removeButton = new JButton("Remove");
        add(removeButton, gbc);
    }

    public EmployeeHistory getHistory() {
        return history;
    }

    public void addActionListener(ActionListener listener) {
        removeButton.addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        removeButton.removeActionListener(listener);
    }

}