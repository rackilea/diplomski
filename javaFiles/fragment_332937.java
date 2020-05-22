JLabel background = new JLabel( new ImageIcon(...) );
background.setLayout( new FlowLayout() );

JComboBox comboBox = new JComboBox();
comboBox.addItem(...);
background.add( comboBox );