for (String color : colors.keySet()) {
  JRadioButton button = new JRadioButton(color);
  ButtonGroup group = new ButtonGroup();
  group.add(button);
  button.setOpaque(false);
  buttonPanel.add(button);
  button.addActionListener(listener);
}