JTextField studIdText = new JTextField(20);

JPanel panel = new JPanel();
panel.setLayout(new GridBagLayout());
GridBagConstraints r1 = new GridBagConstraints();

r1.fill = GridBagConstraints.HORIZONTAL;
r1.weightx = 0.0;
r1.gridx = 0;
r1.gridy = 0;
panel.add(studId,r1);

r1.weightx = 0.5;
r1.gridx = 1;
r1.gridwidth = GridBagConstraints.REMAINDER; 
panel.add(studIdText,r1);