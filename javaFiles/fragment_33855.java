JPanel msgPanel = new JPanel();
msgPanel.setLayout(new GridLayout(3 , 2));

msgPanel.add(new JLabel("Enter name");

JTextField nameField = new JTextField();
msgPanel.add(nameField);

//create other fields and labels

JOptionPane.showMessageDialog(null , msgPanel , "" , JOptionPane.PLAIN_MESSAGE);

String name = nameField.getText();
//read other fields