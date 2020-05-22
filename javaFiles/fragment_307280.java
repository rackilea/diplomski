JPanel fields = new JPanel(new GridLayout(2, 1));
JTextField field = new JTextField(10);
JComboBox<String> comboBox = new JComboBox<>(new String[]{"ham", "spam", "yam"});

fields.add(field);
fields.add(comboBox);

int result = JOptionPane.showConfirmDialog(null, fields, "Breakfast", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
switch (result) {
    case JOptionPane.OK_OPTION:
        // Process the results...
        break;
}