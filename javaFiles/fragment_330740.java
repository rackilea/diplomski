JButton button = new JButton("hello");
button.setSize( button.getPreferredSize() );

DragListener drag = new DragListener();
button.addMouseListener( drag );
button.addMouseMotionListener( drag );

JPanel panel = new JPanel( null );
panel.add( button );

JFrame frame = new JFrame();
frame.add( panel );
frame.setSize(400, 400);
frame.setVisible( true );