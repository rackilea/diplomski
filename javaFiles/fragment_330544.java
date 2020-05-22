String lineNumberPattern = "(\\d+\\s)";
String timeStampPattern = "([\\d:,]+)";
String contentPattern = "(.*)";

// the complete regexp : "(\\d+\\s)([\\d:,]+)( --> )([\\d:,]+)(\\s)(.*)"

String sampleLine = "2\n00:00:02,373 --> 00:00:03,999\nOhh wooaah\n";
Matcher matcher = Pattern.compile(lineNumberPattern + timeStampPattern + "( --> )" + timeStampPattern + "(\\s)" + contentPattern).matcher(sampleLine);

while(matcher.find()) {
    String start = matcher.group(2);
    String end = matcher.group(4);
    String content = matcher.group(6);
    // store those information somewhere
}