public static int countNumbers(int i) {
    StringBuilder buf = new StringBuilder();

    for (int i=1; i<=5; i++) {
      buf.append(i);
    }
    return Integer.parseInt(buf.toString());
}