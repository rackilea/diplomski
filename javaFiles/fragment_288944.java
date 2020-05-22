JLabel background = new JLabel( new ImageIcon(...) );
background.setLayout( new GridBagLayout() );
JPanel buttons = new JPanel();
buttons.setOpaque( false );
buttons.add(...);
background.add(buttons, new GridBagConstraints() );