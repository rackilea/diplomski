JPanel centerPanel = new JPanel(new BorderLayout());
centerPanel.add(new JLabel("center"), BorderLayout.CENTER);
centerPanel.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_END);

JPanel rightPanel = new JPanel();
rightPanel.add(new JLabel("right"));

getContentPane().add(centerPanel, BorderLayout.CENTER);
getContentPane().add(rightPanel, BorderLayout.LINE_END);