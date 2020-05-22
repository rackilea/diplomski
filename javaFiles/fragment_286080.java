public class FormPanel extends JPanel {

    private JTextField fldFirstName;
    private JTextField fldMiddleName;
    private JTextField fldLastName;
    private JTextField fldDateOfBirth;
    private JTextField fldEMail;
    private JButton okButton;
    private JButton cancelButton;

    public FormPanel() {

        setLayout(new BorderLayout());
        add(createFieldsPane());
        add(createButtonsPane(), BorderLayout.SOUTH);

    }

    public JPanel createButtonsPane() {

        JPanel panel = new JPanel(new FlowLayout());
        panel.add((okButton = createButton("Ok")));
        panel.add((cancelButton = createButton("Cancel")));

        return panel;

    }

    protected JButton createButton(String text) {

        return new JButton(text);

    }

    public JPanel createFieldsPane() {

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        panel.add(createLabel("First Name:"), gbc);
        gbc.gridy++;
        panel.add(createLabel("Middle Name:"), gbc);
        gbc.gridy++;
        panel.add(createLabel("Last Name:"), gbc);
        gbc.gridy++;
        panel.add(createLabel("Date of Birth:"), gbc);
        gbc.gridy++;
        panel.add(createLabel("EMail:"), gbc);

        gbc.gridy = 0;
        gbc.gridx++;
        gbc.weightx = 1;
        panel.add((fldFirstName = createField()), gbc);
        gbc.gridy++;
        panel.add((fldLastName = createField()), gbc);
        gbc.gridy++;
        panel.add((fldMiddleName = createField()), gbc);
        gbc.gridy++;
        panel.add((fldDateOfBirth = createField()), gbc);
        gbc.gridy++;
        panel.add((fldEMail = createField()), gbc);

        JPanel filler = new JPanel();
        filler.setOpaque(false);

        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(filler, gbc);

        return panel;

    }

    protected JLabel createLabel(String text) {

        return new JLabel(text);

    }

    protected JTextField createField() {

        JTextField field = new JTextField(12);
        return field;

    }

}