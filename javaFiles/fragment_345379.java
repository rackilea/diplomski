public boolean xyzMiddle(String str) {
  boolean result = false; 
  int i = str.length()/2 -1;

  if (str.length() >= 3 && (str.substring(i, i+3).equals("xyz") || (str.length()%2 == 0 && str.substring(i-1, i+2).equals("xyz"))  )) {
      result = true;
  }
  return result;
}