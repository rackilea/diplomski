JPanel menuPanel = new JPanel()
menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
menuPanel.add(...);
menuPanel.add(...);

JPanel center = new JPanel();
center.setLayout(...);
center.setBackground( Color.BLUE );
center.add(...);

frame.add(menuPanel, BorderLayout.LINE_START);
frame.add(center, BorderLayout.CENTER);
frame.pack();
frame.setVisible( true );