// create JTextField with TF_COLS int column count value
JTextField textField = new JTextField(TF_COLS);

// get the JTextField's default border and make it our inner border
Border innerBorder = textField.getBorder();

// create an outer LineBorder that uses the JPanel's background color
Border outerBorder = BorderFactory.createLineBorder(BACKGROUND);

// create the compound border with these two borders
CompoundBorder myBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

// and set the JTextField's border with it
textField.setBorder(myBorder);