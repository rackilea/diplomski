ActionListener listener = new MenuActionListener();

JMenuItem addOrangeItem = new JMenuItem("Orange");
addOrangeItem.setActionCommand("orange");// set action command
addOrangeItem.addActionListener(listener);

JMenuItem addAppleItem = new JMenuItem("Apple");
addAppleItem.setActionCommand("apple");// set action command
addAppleItem.addActionListener(listener);