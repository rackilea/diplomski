JFrame myFrame = new JFrame();
JPanel myPanel = new JPanel();
JButton myButton = new JButton("myButton");
myPanel.add(myButton);
myPanel.setBackground(Color.BLACK);
myFrame.add(myPanel);
myFrame.pack();
myFrame.setVisible(true);