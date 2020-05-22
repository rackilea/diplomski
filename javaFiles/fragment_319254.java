public static void printCodepoints(char[] s) {
    for (int i = 0; i < s.length; i++) {
      int codePoint = Character.isHighSurrogate(s[i]) ? Character
          .toCodePoint(s[i], s[++i])
          : s[i];
      System.out.println(Integer.toHexString(codePoint));
    }
  }