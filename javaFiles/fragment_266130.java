public TestPane() {
  setLayout(new BorderLayout());
  JLabel label = new JLabel("I'm in the middle");
  label.setHorizontalAlignment(JLabel.CENTER);
  add(label, BorderLayout.NORTH);
}