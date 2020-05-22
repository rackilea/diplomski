JFrame frame = new JFrame("Testing");
frame.setUndecorated(true);
frame.setBackground(new Color(0, 0, 0, 0));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(new TestPane());
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);