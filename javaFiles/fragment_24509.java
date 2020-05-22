JFrame frame = new JFrame("Testing");
frame.setLayout(new FlowLayout()); // New line of code
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setPreferredSize(new Dimension(1000, 2000));  // Modified line of code
frame.setBackground(Color.WHITE);

JPanel jp = new JPanel();
jp.setBackground(Color.BLUE);
jp.setPreferredSize(new Dimension(40, 40)); // Modified line of code
frame.add(jp);

frame.pack(); // added line of code
frame.setVisible(true);