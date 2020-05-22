String data = "It is fun \"to write\" regular\"expression";
List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile("[^\\s\"]+|\"[^\"]*(\"|$)");
Matcher regexMatcher = regex.matcher(data);
while (regexMatcher.find()) {
    System.out.println(regexMatcher.group());
    matchList.add(regexMatcher.group());
}