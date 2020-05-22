class MyProperties extends Properties
{
    // Constructors, as needed
    private Pettern p = Pattern.compile("\\$\\{([^}]+)\\}");
    public String getString(final String key)
    {
        final String value = getProperty(key);
        if (null == value)
            return null;
        final StringBuffer result = new StringBuffer();
        final Matcher m = p.matcher(value);
        while (m.find())
        {
            final String refKey = m.group(1);
            final String refValue = getProperty(refKey);
            m.appendReplacement(result, null == refValue ? refKey : refValue);
        }
        m.appendTail(result);
        return result.toString();
    }
}