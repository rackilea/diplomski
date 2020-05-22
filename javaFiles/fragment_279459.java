String largeText = "a()b a()c a()b";
String phrase = "a()b";
Pattern myPattern = Pattern.compile( "\\b" + Pattern.quote(phrase) + "\\b" );
Matcher myMatcher = myPattern.matcher( largeText );
while(myMatcher.find()) {
  System.out.println(myMatcher.group());
}