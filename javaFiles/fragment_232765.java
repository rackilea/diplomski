JDialog dialog = new JDialog();
JLabel label = new JLabel("Test");
dialog.add(label);

// pack(), setSize(), validate() in this order will
// set sizes on all components as wished
dialog.pack();
dialog.setSize(800, 600);
dialog.validate();

System.out.println(label.getSize());