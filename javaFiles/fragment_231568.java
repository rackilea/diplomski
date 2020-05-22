String string = "<Element createdOn=\"1405358703367\" updatedOn=\"1405358718804\" url=\"http://www.someurl.com\" />";
String patternString = "(url|createdOn|updatedOn)=\"([^\"]*)\"";
Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println(matcher.group(2));
}