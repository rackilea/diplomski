public String sanitiseXml(String xml)
{
    // Match the pattern <something>text</something>
    Pattern xmlCleanerPattern = Pattern.compile("(<[^/<>]*>)([^<>]*)(</[^<>]*>)");

    StringBuilder xmlStringBuilder = new StringBuilder();

    Matcher matcher = xmlCleanerPattern.matcher(xml);
    int lastEnd = 0;
    while (matcher.find())
    {
        // Include any non-matching text between this result and the previous result
        if (matcher.start() > lastEnd) {
            xmlStringBuilder.append(xml.substring(lastEnd, matcher.start()));
        }
        lastEnd = matcher.end();

        // Sanitise the characters inside the tags and append the sanitised version
        String cleanText = StringEscapeUtils.escapeXml10(matcher.group(2));
        xmlStringBuilder.append(matcher.group(1)).append(cleanText).append(matcher.group(3));
    }
    // Include any leftover text after the last result
    xmlStringBuilder.append(xml.substring(lastEnd));

    return xmlStringBuilder.toString();
}