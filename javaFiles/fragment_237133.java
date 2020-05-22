// Class
private static final Pattern FIELD_PATTERN =
    Pattern.compile("<(.*?)>.*?<\\/\\1>");

// Method
{
    Matcher matcher=FIELD_PATTERN.matcher(document_string);
    while(matcher.find())
        System.out.println(matcher.group(1));
}