class MyComp implements Comparator<String> {

  @Override
  public int compare(String str1, String str2) {
     String notDigit = "[^\\d]";
     int int1 = Integer.parseInt(str1.replaceAll(notDigit, ""));
     int int2 = Integer.parseInt(str2.replaceAll(notDigit, ""));
     return Integer.compare(int1, int2);
  }
}