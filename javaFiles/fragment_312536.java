JPanel panel = new JPanel();
JButton button1 = new JButton("Bottom Left");
JButton button2 = new JButton("Bottom Right");
panel.setLayout(new BorderLayout());
panel.add(button1, BorderLayout.LINE_START);
panel.add(button2, BorderLayout.LINE_END);

pane.add(panel, BorderLayout.LINE_END);