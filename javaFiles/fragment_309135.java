int[] charCounts(String s) {
  int[] counts = new int[256]; // maximum value of an ASCII character
  char[] c = s.toCharArray();
  for (int i=0;i<c.length;++i) {
      counts[c[i]]++;
  }
  return counts;
}