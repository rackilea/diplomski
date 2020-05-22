Box vbox = Box.createVerticalBox();

Box hbox = Box.createHorizontalBox();
hbox.add(new JButton("Button"));
hbox.add(Box.createHorizontalStrut(10));
hbox.add(new JButton("Hello"));
vbox.add(hbox);

vbox.add(Box.createVerticalStrut(100));
vbox.add(new JButton("Button2"));