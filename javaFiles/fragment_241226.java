CirclePanel panel = new CirclePanel();

panel.setLayout(new GridBagLayout());

GridBagConstraints gc;

gc = new GridBagConstraints();
gc.gridy = 0;
panel.add(new JLabel("Label 1"), gc);

gc = new GridBagConstraints();
gc.gridy = 1;
panel.add(new JLabel("Label 2"), gc);