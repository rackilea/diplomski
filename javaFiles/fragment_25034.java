private void addComponents() {
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.weighty = 1;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    panel.add(jLabel, gbc);

    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.weightx = 1;
    gbc.weighty = 0;

    panel.add(comboBox, gbc);
}