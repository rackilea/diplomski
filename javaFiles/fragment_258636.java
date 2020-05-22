public static boolean isPal(String s)
{
    if (!isAlphanumeric(s))
        return false;

    return _isPal(s);
}

private static boolean _isPal(String s)
{
    if (s.length() == 0 || s.length() == 1)
        return true;

    if (s.charAt(0) == s.charAt(s.length()-1))
        return _isPal(s.substring(1, s.length()-1));

    return false;
}

private static boolean isAlphanumeric(String str) 
{
    for (int i = 0; i < str.length(); i++) 
    {
        char c = str.charAt(i);

        if (!Character.isLetter(c) && !Character.isDigit(c))
            return false;
    }
    return true;
}