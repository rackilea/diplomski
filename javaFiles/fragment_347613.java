BufferedReader bufferedInput = new BufferedReader(System.in);
String line = bufferedInput.readLine();
if (line == null) { /* handle end of input case */ }
String number = line.trim();
// Check if its a palindrome
if (number.length() == 4
    && number.charAt(0) == number.charAt(3)
    && number.charAt(1) == number.charAt(2)) {
  // Finally check that the characters are all digits
  boolean isLegal = true;
  for (int i = (number.length() + 1) / 2; --i >= 0;) {
    char shouldBeADigit = number.charAt(i);
    if (!('0' <= shouldBeADigit && shouldBeADigit <= '9')) {
      isLegal = false;
      break;
    }
  }
  if (isLegal) {
    System.out.println(number + " is a palindrome");
  }
}