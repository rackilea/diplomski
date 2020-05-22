boolean validatePassword(char[] password, int n, int m) {
  if (password == null || password.length < n || password.length > m) {
    return false;
  }
  boolean upper = false;
  boolean lower = false;
  boolean digit = false;
  boolean symbol = false;
  for (char ch : password) {
    if (Character.isUpperCase(ch)) {
      upper = true;
    } else if (Character.isLowerCase(ch)) {
      lower = true;
    } else if (Character.isDigit(ch)) {
      digit = true;
    } else { // or some symbol test.
      symbol = true;
    }
    // This short-circuits the rest of the loop when all criteria are true.
    if (upper && lower && digit && symbol) {
      return true;
    }
  }
  return upper && lower && digit && symbol;
}