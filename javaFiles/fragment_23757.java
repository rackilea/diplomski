JFrame frame = new JFrame();
JTabbedPane tp = new JTabbedPane();
tp.addTab("hello", new JPanel());
tp.addTab("there", new JPanel());
frame.getContentPane().add(tp, BorderLayout.CENTER);

// Null layout used here for demonstration purposes only
JPanel glassPane = new JPanel(null);
glassPane.setOpaque(false);
frame.getRootPane().setGlassPane(glassPane);
// This is important, as setGlassPane makes it invisible
glassPane.setVisible(true);

JButton helpButton = new JButton("Help");
helpButton.setBounds(800, 5, 50, 20);
glassPane.add(helpButton);

frame.setSize(new Dimension(900, 800));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);