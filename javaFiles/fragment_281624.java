JTextField field = new JTextField("Hello, World");
JPanel accessory = new JPanel();
accessory.setLayout(new FlowLayout());
accessory.add(field);

JFileChooser chooser = new JFileChooser();
chooser.setAccessory(accessory);
int ret = chooser.showOpenDialog(frame);