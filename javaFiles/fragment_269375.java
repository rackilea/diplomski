public static String[] reverse(String[] list) {
  String[] temp = new String[list.length];
  for (int i = 0; i < list.length; i++) {
    temp[i] = list[list.length - i - 1];
  }
  return temp;
}