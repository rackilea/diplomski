// do this *before* the for-loop
ButtonGroup group = new ButtonGroup();

for (String color : colors.keySet()) {
  JRadioButton button = new JRadioButton(color);
  // ButtonGroup group = new ButtonGroup(); // not *inside* the for loop
  group.add(button);  // then use it here
  button.setOpaque(false);
  buttonPanel.add(button);
  button.addActionListener(listener);
}