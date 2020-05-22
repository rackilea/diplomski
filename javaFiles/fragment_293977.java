JPanel east = new JPanel( new BorderLayout() );
JPanel buttons = new JPanel( new GridLayout(0, 1) );
east.add(buttons, BorderLayout.NORTH);
buttons.add( button1 );
buttons.add( button2 );
frame.add(east, BorderLayoutEAST);