public static boolean checkString (String word) {
  int len = word.length();
  word = word.toUpperCase(); //since you are testing them as upper case
  char firstLetter = word.charAt(0);
  char lastLetter = word.charAt(len - 1);
  return firstLetter == lastLetter;
}