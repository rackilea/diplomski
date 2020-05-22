gbc.gridx = 0;
gbc.gridy = 2;
gbc.gridwidth = 2;
gbc.gridheight = 7;
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.fill = GridBagConstraints.VERTICAL;
cp.add(pl, gbc);

JPanel p1 = new JPanel();
p1.add(btnAddProgram);
p1.add(btnDelProgram);
gbc.gridx = 0;
gbc.gridy = 9;
cp.add(p1, gbc);