public static String perm(String word){
    int l = word.length();
    int[] els = new int[l];
    for (int i=0; i<l; i++) {
      els[i] = (word.charAt(i) << 16) | i;
    }
    Arrays.sort(els);
    char[] sb = new char[l];
    for (int i=0; i<els.length; i++) {
      sb[i] = (char)('A' + els[i] & 0xFFFF);
    }
    return String.valueOf(sb);
  }