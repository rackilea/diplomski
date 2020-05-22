private static String identifierOrString = "[a-zA-Z0-9_\\.\\(\\),]+";

public static void main(String[] args) {

  String testCase = "SELECT col1, col2||word||default_col||another field1, col3 || ' quote test ' || default_1 field2 FROM table where 'abc' = col4 || col5 || col6 GROUP BY col7 || col8";

  testCase = convertBeginnings(testCase);
  System.out.println("Phase 1: " + testCase);

  testCase = convertEndings(testCase);
  System.out.println("Phase 2: " + testCase);

  testCase = convertRemainingOperators(testCase);
  System.out.println("Finished: " + testCase);    
}

private static String convertBeginnings(String testCase) {
  return replace("(SELECT|WHERE|=|<>|like|GROUP BY|\\,)(\\s+)(%s|'[^']*')\\s*\\|\\|", testCase, "%s %s concat(%s ||");
}

private static String convertEndings(String testCase) { 
  return replace("\\|\\|\\s*(%1$s|'[^']*')\\s*(\\s%1$s)?\\s*((\\,|FROM|GROUP BY|ORDER BY|=|<>|like|$))", testCase,",%s) %s %s");
}

private static String replace(String regexp, String source , String target) {
  Matcher m = match(regexp, source);
  while(m.find()) {
    source = source.replace(m.group(0), String.format(target, nvl(m.group(1)), nvl(m.group(2)), nvl(m.group(3))));
  }
  return source;
}

private static String nvl(String value) {
  return null == value ? "" : value;
}

private static String convertRemainingOperators(String testCase) {
  return testCase.replaceAll("\\|\\|", ",");
}

private static Matcher match(String regexp, String target ) {
  Pattern p = Pattern.compile(String.format(regexp, identifierOrString), Pattern.CASE_INSENSITIVE|Pattern.MULTILINE|Pattern.DOTALL);
  return p.matcher(target); 
}