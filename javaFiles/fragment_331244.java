static void printAllPossibilities(String charSet, int length) {
  printAllPossibilities_(charSet, length, "");
}

static void printAllPossibilities_(String charSet, int length, String temp) {
  if (length == 0) {
    System.out.println(temp);
    return;
  }
  for (int i = 0; i < charSet.length(); i++)
    printAllPossibilities_(charSet, length - 1, temp + charSet.charAt(i));
}