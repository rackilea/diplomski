GridBagConstraints gbc = new GridBagConstraints();
gbc.anchor = GridBagConstraints.NORTHWEST;

JLabel testLabel = new JLabel();
testLabel.setText("Test");
gbc.gridx = 0;
gbc.gridy = 0;
gbc.weighty = 0;
gbc.weightx = 0;
right.add(testLabel, gbc);

JLabel test2Label = new JLabel();
test2Label.setText("test2");
gbc.gridx = 0;
gbc.gridy = 1;
gbc.weighty = 1;
gbc.weightx = 1;
right.add(test2Label, gbc);