public static void main(String[] args) {
  String inputText = "dog1 start dog2a dog2b end dog3 start dog4a dog4b end dog5";

  StringBuffer result = new StringBuffer();
  Pattern pattern = Pattern.compile("(start(.*?)end)");

  Matcher matcher = pattern.matcher(inputText);

  while (matcher.find())
    matcher.appendReplacement(result, processSubGroup(matcher.group(1), matcher.group(2)));

  matcher.appendTail(result);
  System.out.println("Final result   = " + result);
}

static String processSubGroup(String subGroup, String contents) {
  return Pattern.compile("dog").matcher(subGroup).replaceAll("cat");
}