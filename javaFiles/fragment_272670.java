import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Class {
  private static final Pattern p = Pattern.compile("" +
    "((?<threeDigits>\\d{3})[- ]?)?" +
    "(?<tenDigits>\\d{10})");

  public static void main(String... args) {
    final String input =
      "Here is some text to match: Some random text 080 2668215901. " +
        "We're now matching stray sets of ten digit as well: 1234567890. " +
        "Notice how you get the first ten and the second ten, with the preceding three:1234123412-040-1234567890" +
        "A stranger case:111222333444555666777888. Where should matches here begin and end?";
    printAllMatches(p.matcher(input));
  }

  private static void printAllMatches(final Matcher m) {
    while (m.find()) {
      System.out.println("three digits: " + m.group("threeDigits"));
      System.out.println("ten digits: " + m.group("tenDigits"));
    }
  }

}