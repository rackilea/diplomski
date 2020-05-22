public static void main(String... args) {
  String bigger = "I AM IN AMSTERDAM";
  String smaller = "AM";

  System.out.println("Output: As part of string: " + countMatches(bigger, smaller) +
          ", as a part of word: " + countMatches(bigger, "\\b" + smaller + "\\b"));
}

private static int countMatches(String in, String regex) {
  Matcher m = Pattern.compile(regex).matcher(in);
  int count = 0;
  while (m.find()) count++;
  return count;
}