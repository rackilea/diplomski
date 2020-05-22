public boolean containsBothNumbersAndLetters(String password) {
  boolean digitFound = false;
  boolean letterFound = false;
  for (char ch : password.toCharArray()) {
    if (Character.isDigit(ch)) {
      digitFound = true;
    }
    if (Character.isLetter(ch)) {
      letterFound = true;
    }
    if (digitFound && letterFound) {
      // as soon as we got both a digit and a letter return true
      return true;
    }
  }
  // if not true after passing through the entire string, return false
  return false;
}