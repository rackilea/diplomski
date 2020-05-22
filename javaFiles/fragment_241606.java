String text = "HERE THE TEXT YOU WANT TO PARSE";

String patternStr = "\\b(\\w+(?:_DBF|_REP|_TABLE|_TBL))\\b";

Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(text);

while(matcher.find()) {
    System.out.println("found: " + matcher.group(1));
}