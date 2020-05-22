JPanel middlePanel = new JPanel (new BorderLayout());
middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );

JTextArea display = new JTextArea ( 16, 58 );
display.setEditable ( false ); // set textArea non-editable
JScrollPane scroll = new JScrollPane ( display );
scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

middlePanel.add ( scroll );

JPanel buttonPane = new JPanel(); // FlowLayout by default...
buttonPane.add(...); // Add your buttons here...

JFrame frame = new JFrame ();
frame.add ( middlePanel );
frame.add(buttonPane, BorderLayout.SOUTH);
frame.pack ();
frame.setLocationRelativeTo ( null );
frame.setVisible(true);