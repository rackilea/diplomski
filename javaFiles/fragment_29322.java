JTextArea textArea = ...
JPanel pnl = new JPanel(new BorderLayout());

pnl.add(new JLabel("Please enter some data:"), BorderLayout.NORTH);
pnl.add(textArea, BorderLayout.CENTER);

JOptionPane.show...