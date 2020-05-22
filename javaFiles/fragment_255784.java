JFrame frame = new JFrame();
// set up frame

JTable table = new JTable();
// Set up table, add data

// Frame has a content pane with BorderLayout by default
frame.getContentPane().add( new JScrollPane( table ), BorderLayout.CENTER );