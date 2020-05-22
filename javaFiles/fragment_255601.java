JLabel background = new JLabel(...);
background.setAlignmentX(0.0f);
background.setAlignmentY(0.5f);

JPanel buttonsPanel = new JPanel( set your layout );
buttonsPanel.setOpaque( false );
buttonsPanel.setBorder( new EmptyBorder(...) );
buttonsPanel.setAlignmentX(0.0f);
buttonsPanel.setAlignmentY(0.5f);

JPanel overlayPanel = new JPanel( new OverLayLayout(...) );
overlayPanel.add(background);
overlayPanel.add(buttonsPanel);