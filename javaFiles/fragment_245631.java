public static boolean isNullOrEmpty(String string)
{
    return string == null || string.length() == 0;
}
public static String substring(String string, int start, int length)
{
    if (length < 0)
        throw new IndexOutOfBoundsException("Parameter length cannot be negative.");

    return string.substring(start, start + length);
}