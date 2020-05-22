public static StringBuilder replaceExclamation(StringBuilder userText){
  int i = 0;
 for ( i=0; i < userText.length(); ++i) {
  char currentChar = userText.charAt(i);
  if (currentChar == '!') {
     userText.setCharAt(i,'.');
    }
  }
  return userText;
}