JFrame frame = new JFrame("Testing");

frame.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.insets  = new Insets(4, 4, 4, 4);
gbc.anchor = gbc.WEST;

frame.add(new JLabel("12345678"), gbc);
gbc.gridx++;
frame.add(new JLabel("-12,231"), gbc);

gbc.gridy++;
gbc.gridx = 0;
frame.add(new JLabel("1234"), gbc);
gbc.gridx++;
frame.add(new JLabel("-123.000"), gbc);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);