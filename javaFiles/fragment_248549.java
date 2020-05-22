public static String reverse(String orig)
{
    char[] s = orig.toCharArray();
    final int n = s.length;
    final int halfLength = n / 2;
    for (int i=0; i<halfLength; i++)
    {
        char temp = s[i];
        s[i] = s[n-1-i];
        s[n-1-i] = temp;
    }
    return new String(s);
}