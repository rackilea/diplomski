int index = 0;
for (int i = 0; i < numberButton.length; i++) {
  // fill numberButton[i] using calcButtons[index]
  index++;
}
for (int i = 0; i < operatorButtons.length; i++) {
  // fill in operatorButtons[i], use calcButtons[index]
  index++;
}

/// ... etc
return new JButton[][]{numberButton, ..... etc...};