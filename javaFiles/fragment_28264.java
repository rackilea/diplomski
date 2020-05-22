JPanel grid = new JPanel( new GridLayout(...) );

JPanel wrapper = new JPanel( new GridBagLayout() );
wrapper.add(grid, new GridBagConstraints());

frame.add(wrapper, BorderLayout.CENTER);