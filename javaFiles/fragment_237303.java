public static boolean isPalindrome(String word) {
  //Strip out non-alphanumeric characters from string
  String cleanWord = word.replaceAll("[^a-zA-Z0-9]","");
  //Check for palindrome quality recursively
  return checkPalindrome(cleanWord);
}
private static boolean checkPalindrome(String word) {
  if(word.length() < 2) { return true;  }
  char first  = word.charAt(0);
  char last   = word.charAt(word.length()-1);
  if(  first != last  ) { return false; }
  else { return checkPalindrome(word.substring(1,word.length()-1)); }
}