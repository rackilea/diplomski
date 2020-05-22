JLabel label2 = new JLabel( new ColorIcon(Color.GREEN, 40, 40) );
label2.setSize( label2.getPreferredSize() );
label2.setLocation(500, 500);
contentPane.add( label2 );

KeyboardAnimation animation2 = new KeyboardAnimation(label2, 24);
animation2.addAction("A", -3,  0);
animation2.addAction("D", 3,  0);
animation2.addAction("W",    0, -3);
animation2.addAction("S",  0,  3);