JScrollPane master = new JScrollPane( new ScrollSSCCE() );
master.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

JFrame frame = new JFrame("Scroll SSCCE");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//frame.add( new ScrollSSCCE() );
frame.add( master );
frame.setLocationByPlatform( true );
frame.setSize(200, 400);
frame.setVisible( true );