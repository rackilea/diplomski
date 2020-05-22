JTextPane pane = new JTextPane();
JFrame frame = new JFrame("Example");
frame.add(pane);
frame.setVisible(true);
File file = new File(args[0]);
pane.setPage(file.toURL().toString());
frame.pack();