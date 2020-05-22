JPanel panel2 = new JPanel();
GridLayout grid1 = new GridLayout(4, 2);

panel2.setLayout(grid1);
panel2.add(new JCheckBox("Bold"));
panel2.add(new JCheckBox("Strikerthrough"));
panel2.add(new JCheckBox("Italic"));
panel2.add(new JCheckBox("Teletype"));
panel2.add(new JCheckBox("Underline"));
panel2.add(new JCheckBox("Emphasis"));
panel2.add(new JLabel(""));  // fill the empty cell with an empty label
panel2.add(new JCheckBox("Strong"));