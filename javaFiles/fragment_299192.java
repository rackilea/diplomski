UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );

JFrame frame = new JFrame();
frame.setBounds( 50, 50, 800, 600 );
frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

JPanel glasspane = new JPanel(new FlowLayout(FlowLayout.RIGHT));

frame.setGlassPane( glasspane );

glasspane.setOpaque( false );
JTextField textField = new JTextField("Search");
glasspane.add(textField);
glasspane.setVisible( true );

JTabbedPane tabs = new JTabbedPane();
tabs.setBorder( BorderFactory.createEmptyBorder( 10, 5, 5, 5 ) );
tabs.addTab( "Lorem", null );
tabs.addTab( "Ipsum", null );
tabs.addTab( "Dolor", null );
frame.setContentPane( tabs );
frame.setVisible( true );