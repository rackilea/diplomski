Box box = Box.createHorizontalBox();

JLabel longLabel = new JLabel("this has lots fo text");
longLabel.setMinimumSize( new Dimension(0, 0) );
box.add(longLabel);

box.add(Box.createHorizontalStrut(5));

JLabel shortLabel = new JLabel("little text");
box.add(shortLabel);