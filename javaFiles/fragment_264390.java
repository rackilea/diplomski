JFrame frame = new JFrame("Demo");
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
frame.setSize(250,250);
JButton button = new JButton("Add tab to another frame.");
button.addActionListener(this);
frame.add(button);
frame.setVisible(true);