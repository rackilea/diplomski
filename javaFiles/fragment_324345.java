String[] dummyList  = new String[] {
    "Val 1",
    "Val 2"
};
JPanel gridBagPanel = new JPanel(new GridBagLayout());
GridBagConstraints gc = new GridBagConstraints();

gc.weighty = 1; //Delete this line if you are after an equivalent of `center, center` from the MigLayout
gc.gridwidth = 4;
gridBagPanel.add(new JLabel("Header"), gc);

gc.gridy = 1;
gc.gridwidth = 1;
gridBagPanel.add(new JTextField("Input"), gc);

gc.gridx = 1;
gridBagPanel.add(new JComboBox<String>(dummyList), gc);

gc.gridx = 2;
gridBagPanel.add(new JLabel("To"), gc);

gc.gridx = 3;
gridBagPanel.add(new JComboBox<String>(dummyList), gc);

gc.gridy = 2;
gc.gridx = 0;
gc.gridwidth = 4;
gridBagPanel.add(new JButton("Convert"), gc);

gc.gridy = 3;
gridBagPanel.add(new JTextField("Output"), gc);