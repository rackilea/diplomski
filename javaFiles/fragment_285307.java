JPanel labelPanel = new JPanel();
labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
labelPanel.add(leftLabel);
labelPanel.add(Box.createGlue()); //creates space between the JLabels
labelPanel.add(rightLabel);

contentPane.add(labelPanel);