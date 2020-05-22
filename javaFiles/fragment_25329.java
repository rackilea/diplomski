public static boolean isProbablyArabic(String s) {
    for (int i = 0; i < s.length();) {
        int c = s.codePointAt(i);
        if (c >= 0x0600 && c <= 0x06E0)
            return true;
        i += Character.charCount(c);            
    }
    return false;
  }