public static void main(String[] args) {
  String inputText = "dog1 start dog2a dog2b end dog3 start dog4a dog4b end dog5";

  System.out.println("Input          = " + inputText);
  StringBuffer result = new StringBuffer();
  Pattern pattern = Pattern.compile("(start(.*?)end)");

  Matcher matcher = pattern.matcher(inputText);

  while (matcher.find()) {
    int s = matcher.start();
    int e = matcher.end();
    System.out.printf("(%d .. %d) -> \"%s\"\n", s, e, matcher.group(1));
    matcher.appendReplacement(result, processSubGroup(matcher.group(1), matcher.group(2)));
  }
  matcher.appendTail(result);
  System.out.println("Final result   = " + result);
}

static String processSubGroup(String subGroup, String contents) {
  StringBuffer result = new StringBuffer();
  Pattern pattern = Pattern.compile("dog");

  Matcher matcher = pattern.matcher(subGroup);

  while (matcher.find())
    matcher.appendReplacement(result, "cat");

  matcher.appendTail(result);
  return result.toString();
}