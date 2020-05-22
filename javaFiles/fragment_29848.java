JPanel centerPanel = new JPanel();
centerPanel.add(month);
centerPanel.add(year);

JPanel mainPanel = new JPanel( new BorderLayout() );
mainPanel.add(westButton, BorderLayout.WEST);
mainPanel.add(centerPanel, BorderLayout.CENTER);
mainPanel.add(eastButton, BorderLayout.EAST);