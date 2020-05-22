@Override
public boolean equals(final Object o)
{
    if (o instanceof MyObject)
    {
        return (0 == this.compareTo(((MyObject) o)));
    }
    return false;
}

@Override
public int hashCode()
{
    return getKeyValuePairs(this.myMap).hashCode();
}

// Return a negative integer, zero, or a positive integer
// if this object is less than, equal to, or greater than the other object
public int compareTo(final MyObject o)
{
    return this.hashCode() - o.hashCode();
}

// The Map is flattened into a single String for comparison
private static String getKeyValuePairs(final Map<String, String> m)
{
    final StringBuilder kvPairs = new StringBuilder();

    final String kvSeparator = "=";
    final String liSeparator = "^";

    if (null != m)
    {
        final List<String> keys = new ArrayList<>(m.keySet());
        Collections.sort(keys);

        for (final String key : keys)
        {
            final String value = m.get(key);
            kvPairs.append(liSeparator);
            kvPairs.append(key);
            kvPairs.append(kvSeparator);
            kvPairs.append(null == value ? "" : value);
        }
    }

    return 0 == kvPairs.length() ? "" : kvPairs.substring(liSeparator.length());
}