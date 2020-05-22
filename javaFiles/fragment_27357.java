final JFrame frame = new JFrame();
frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
frame.setLayout(new GridBagLayout());

GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.fill = GridBagConstraints.BOTH;
gbc.weightx = 1.0;
gbc.weighty = 1.0;
frame.add(Box.createGlue(), gbc);

final JTextArea textArea = new JTextArea("SE");
textArea.setPreferredSize(new Dimension(50, 50));
textArea.setOpaque(true);
textArea.setBackground(Color.RED);
gbc = new GridBagConstraints();
gbc.gridx = 1;
gbc.gridy = 1;
gbc.fill = GridBagConstraints.NONE;
gbc.weightx = 0.0;
gbc.weighty = 0.0;
frame.add(textArea, gbc);

frame.setSize(640, 480);
frame.setVisible(true);