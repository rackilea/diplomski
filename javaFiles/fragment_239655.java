int wrongCounter = 0;
int rightCounter = 0;

public void actionPerformed(ActionEvent e) {
  char currentCharacter = textField.getText().charAt(0);

  if (set.contains(currentCharacter)) {
    ++rightCounter;
    // whatever
  }
  else {
    ++wrongCounter;
  }

  if (set.size() == 0 || wrongCounter == 8)
    hangMan();  // doesn't need parameter anymore, it's outside the method
}