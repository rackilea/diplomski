public static void reverse(String[] list) {
  for (int i = 0; i < list.length / 2; i++) {
    String t = list[list.length - i - 1];
    list[list.length - i - 1] = list[i];
    list[i] = t;
  }
}