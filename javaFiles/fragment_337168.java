static bool compareMultiStrings(String words, String ... stringi) {
  if (words == null) return false;

  for(String  s : stringi){
    if (words.equals(s)) return true;
  }

  return false;
}