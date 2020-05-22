public boolean endOther(String a, String b) {
  a = a.toLowerCase();
  b = b.toLowerCase();
  if (a.contains(b) && a.lastIndexOf(b) == a.length() - b.length()) {
    return true;
  } else if (b.contains(a) && b.lastIndexOf(a) == b.length() - a.length()) {
    return true;
  } else {
    return false; 
  }
}