//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

JButton button = new JButton("testing");
button.setBackground(Color.RED);

JFrame frame = new JFrame("SSCCE");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add( button );
frame.pack();
frame.setLocationByPlatform( true );
frame.setVisible( true );