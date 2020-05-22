public TestPane() {
  setLayout(new GridBagLayout());
  GridBagConstraints gbc = new GridBagConstraints();
  gbc.weighty = 1;
  gbc.anchor = GridBagConstraints.NORTH;
  add(new JLabel("I'm in the middle"), gbc );
}