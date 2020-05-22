JPanel panel = new JPanel(new MigLayout("flowy, fillx, filly", "[fill, grow]", "[fill, 0:100:300][fill, 0:100:max(100%,300)]"));
JPanel redPanel = new JPanel();
redPanel.setBackground(Color.RED);
JPanel bluePanel = new JPanel();
bluePanel.setBackground(Color.BLUE);

panel.add(redPanel);
panel.add(bluePanel);

JFrame frame = new JFrame();
frame.add(panel);
frame.pack();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);