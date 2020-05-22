interface GroupProcessor {
  String process(String group);
}

public static void main(String[] args) {
  String inputText = "dog1 dogs dog2a dog2b enddogs cow1 dog3 cows cow2a cow2b endcows dog4 dogs dog5a dog5b enddogs cow3";

  String result = inputText;

  result = processGroup(result, "dogs*enddogs", (group) -> {
    return Pattern.compile("dog").matcher(group).replaceAll("cat");
  });

  result = processGroup(result, "cows*endcows", (group) -> {
    return Pattern.compile("cow").matcher(group).replaceAll("sheep");
  });

  System.out.println("Input        = " + inputText);
  System.out.println("Final result = " + result);
}

static String processGroup(String input, String regex, GroupProcessor processor) {
  StringBuffer result = new StringBuffer();
  Pattern pattern = Pattern.compile(String.format("(%s)", regex.replace("*", "(.*?)")));

  Matcher matcher = pattern.matcher(input);

  while (matcher.find())
    matcher.appendReplacement(result, processor.process(matcher.group(1)));

  matcher.appendTail(result);
  return result.toString();
}