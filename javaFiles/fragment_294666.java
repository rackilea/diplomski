public static void main(String[] args) {
    String s = "asdfasdfasasasasa";
    int[] counters = new int[65536];

    for (char c: s.toCharArray()) ++counters[c];
    for (int i = 0; i < counters.length; ++i) {
      if (counters[i] > 0) System.out.println((char)i + " - " + counters[i]);
    }
}