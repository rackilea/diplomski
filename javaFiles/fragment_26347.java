JButton button = new JButton( "Tailand" );

JPanel left = new JPanel( new BorderLayout() );
left.setBackground( Color.WHITE );
left.add(button, BorderLayout.PAGE_END);

JFrame frame = new JFrame("Flag Menu");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frane.setLocationRelativeTo(null);
frame.add(left, BorderLayout.LINE_START);
frame.setSize(600, 400);
frame.setVisible(true);