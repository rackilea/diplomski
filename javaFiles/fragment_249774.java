// create another panel
JPanel panelFormat = new JPanel();
//create a textfield
JTextField txtfield = new JTextField(10);
//create a label for the textfield
JLabel label = new JLabel("Guesss");
//set the layout type for this panel
panelFormat.setLayout(new GridBagLayout());
//add label to panel
panelFormat.add(label);
//add textfield to panel
panelFormat.add(txtfield);
//I dont know the difference between the below two
//BorderLayout.CENTER still does not center the panel in the frame, I dont know why
myframe.getContentPane().add(panelFormat, BorderLayout.CENTER);
myframe.add(panelFormat);