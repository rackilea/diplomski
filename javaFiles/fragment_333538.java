private Pattern pattern;
private Matcher matcher;
private Pattern endPattern;
private Matcher endMatcher;

private static final String HTML_TAG_PATTERN = "<([a-zA-Z]+)>[^<]*";
public boolean hasCorrectHTML(String checking)
{
    boolean ret=true;
    pattern=Pattern.compile(HTML_TAG_PATTERN);
    matcher=pattern.matcher(checking);

    while(matcher.find() && ret)
    {
        String htmlEndTag="</"+matcher.group(1)+">";

        endPattern=Pattern.compile(htmlEndTag);

        String endChecking = checking.substring(matcher.end());
        endMatcher=endPattern.matcher(endChecking);

        ret=endMatcher.matches();
    }

    return ret;
}