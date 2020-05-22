JPanel panel = new JPanel();
SpringLayout sl_panel = new SpringLayout();
panel.setLayout(sl_panel);

JButton button = new JButton("Comments");
sl_panel.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, panel);
sl_panel.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, panel);
panel.add(button);

JScrollPane scrollPane = new JScrollPane();
sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, panel);
sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 3, SpringLayout.WEST, panel);
sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, 3, SpringLayout.SOUTH, panel);
sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 3, SpringLayout.EAST, panel);
panel.add(scrollPane);

JLabel lblNewLabel = new JLabel();
lblNewLabel.setIcon(new ImageIcon(foo.class.getResource("sSdA3.png")));
scrollPane.setViewportView(lblNewLabel);