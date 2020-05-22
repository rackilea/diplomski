public static boolean digitCheck(String string) {
  if (string != null) { // <--- Add This
    for (int i = 0; i < string.length(); i++) {
      if (!Character.isDigit(string.charAt(i)))
        return false;
    }
    return true; // we only got here if there were characters, and they're all digit(s).
  }
  return false; 
}