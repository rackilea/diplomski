radioButtonMenuPanel.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = GridBagConstraints.RELATIVE;
gbc.anchor = GridBagConstraints.WEST;

ButtonGroup group = new ButtonGroup();
for (String item : answerItems) {
    JRadioButton radioButton = new JRadioButton(item);
    group.add(radioButton);
    radioButtonMenuPanel.add(radioButton, gbc);
}