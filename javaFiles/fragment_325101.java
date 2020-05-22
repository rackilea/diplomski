private String stripXSS(String value)
{
    if ((value != null) && (value.length() > 0))
    {
        for (final Pattern scriptPattern : patterns)
        {
            value = scriptPattern.matcher(value).replaceAll("");
        }
    }
    return value;
}