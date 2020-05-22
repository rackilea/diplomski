// I want the scrollpane to take up 1/4 the width of the window.
gbc.fill = GridBagConstraints.BOTH;
gbc.gridwidth = 1;
gbc.gridx = 0;
gbc.gridy = 1;
gbc.weightx = 0.25;
gbc.weighty = 1;
add(scrollpane, gbc);

// I want the textarea to take up 3/4 the width of the window.
gbc.gridx = 1;
gbc.gridy = 1;
gbc.weightx = 0.75;
add(textarea, gbc);