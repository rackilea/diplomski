gbc.anchor = GridBagConstraints.NORTH;
gbc.weightx = 1.0;
gbc.weighty = 1.0;

gbc.gridx = 1;
gbc.gridy = 0;

panel1.add(new JButton("Hello"), gbc);

gbc.gridx = 2; // now a 2nd cell exists
panel1.add(new JButton("Test"), gbc);