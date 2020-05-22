JFrame newFrame = new JFrame();
newFrame.setLayout(new FlowLayout());
newFrame.setDefaultCloseOperation(newFrame.EXIT_ON_CLOSE);

bluePill = new JButton("Blue Pill");
newFrame.add(bluePill);
redPill = new JButton("Red Pill");
newFrame.add(redPill);

newFrame.pack();
newFrame.setVisible(true);