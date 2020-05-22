// validate that a password adheres to the "rules".
private static boolean validate(String password) {
  // Check for null, then a length less then 6 (and I really don't like the length()
  // > 10 check, that's a BAD requirement).
  if (password == null || password.length() < 6 || password.length() > 10) {
    return false;
  }
  boolean containsChar = false;
  boolean containsDigit = false;
  for (char c : password.toCharArray()) {
    if (Character.isLetter(c)) {
      containsChar = true;
    } else if (Character.isDigit(c)) {
      containsDigit = true;
    }
    if (containsChar && containsDigit) {
      return true;
    }
  }
  return false;
}