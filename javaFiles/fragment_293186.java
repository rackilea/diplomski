/**
 * jstl's fn:join only works with String[].  This one is more general.
 * 
 * usage: ${nc:join(values, ", ")}
 */
public static String join(Object values, String seperator)
{
    if (values == null)
        return null;
    if (values instanceof Collection<?>)
        return StringUtils.join((Collection<?>) values, seperator);
    else if (values instanceof Object[])
        return StringUtils.join((Object[]) values, seperator);
    else
        return values.toString();
}