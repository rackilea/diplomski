public static <T> T findFirst(Iterable<? extends T> collection, T value)
{
    for (T t : collection)
    {
        if (t.equals(value))
        {
            return t;
        }
    }
    return null;
}