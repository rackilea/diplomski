JButton someButton = new JButton("SOME BUTTON");
JButton someOtherButton = new JButtton("SOME OTHER BUTTON");

ActionListener listener = new MyListener();

someButton.addActionListener(listener);
someOtherButton.addActionListener(listener);