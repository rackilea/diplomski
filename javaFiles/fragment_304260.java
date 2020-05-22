for (int i = 0; i < names.length; i++) {
  nameInput = JOptionPane.showInputDialog ("Enter a name:");
  names[i] = nameInput;
  length = names[i].length();

  // sort into alphabetical order
  for (int j = 0; j < names.length - 1; j++) {
    for (int k = j + 1; k < names.length; k++) {
      if (names[j].compareToIgnoreCase(names[k]) > 0) {