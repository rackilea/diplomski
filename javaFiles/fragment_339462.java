JPanel panel = new JPanel(new GridBagLayout());
panel.add(new JLabel("Type: "));
GridBagConstraints gbc = new GridBagConstraints();
gbc.weightx = 1;
gbc.anchor = GridBagConstraints.WEST;
panel.add(new JComboBox(new String[]{"This is a test"}), gbc);