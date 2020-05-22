public static String cipher(String sentence, int offset) {
  String s = "";
  for(int i = 0; i < sentence.length(); i++) {
    char c = (char)(sentence.charAt(i));
    if (c >= 'A' && c <= 'Z') {     
      s += (char)((c - 'A' + offset) % 26 + 'A');
    } else if (c >= 'a' && c <= 'z') {
      s += (char)((c - 'a' + offset) % 26 + 'a');
    } else {
      s += c;
    }
  }
  return s;
}