public static boolean isValid(String address) {
  Set<String> stopWords = getSet();  // some magic to get the loaded set
  for (String stopWord:stopWords) {
    if (address.trim().toLowerCase().startsWith(stopWord.toLowerCase())) {
       return false;
    }
  }
  return true;
}