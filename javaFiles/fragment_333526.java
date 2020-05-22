setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.gridwidth = GridBagConstraints.REMAINDER;
gbc.weightx = 1;

add(namePanel, gbc);
add(actionsPanel, gbc);
add(entryPanel, gbc);