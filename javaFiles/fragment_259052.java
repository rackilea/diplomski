JPanel tab1 = new JPanel();
tab1.background( Color.RED );

JTabbedPane tabbedPane = new JTabbedPane();
tabbedPane.add(tab1, "Tab1");

JPanel parent = new JPanel( new BorderLayout() );
parent.setBackground( Color.GREEN );
parent.add( tabbedPane );

frame.add( parent );