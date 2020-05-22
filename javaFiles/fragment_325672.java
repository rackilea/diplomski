JFrame f = new JFrame("Test");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.add(new JLabel("Test"), BorderLayout.WEST);
JButton b = new JButton("Test");
f.add(b);
f.pack();
f.setLocationRelativeTo(null);
f.setVisible(true);
System.out.println(SwingUtilities.convertPoint(b, b.getX(), b.getY(), f));