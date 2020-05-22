JPanel panel = new JPanel();
panel.setPreferredSize( new Dimension(1400, 600) );

JFrame frame = new JFrame();
frame.add( panel );
frame.pack();
frame.setMaximumSize( new Dimension(1300, 500) );
frame.setVisible( true );