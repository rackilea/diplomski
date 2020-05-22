public static int findDifferingIndex(final String s1, final String s2)
{
    final int len1 = s1.length();
    final int len2 = s2.length();
    final int len = Math.min(len1, len2);

    for (int index = 0; index < len; index++)
        if (s1.charAt(index) != s2.charAt(index))
            return index;

    // Check the length of both strings; if they are equal, return -1.
    // Otherwise return the length `len`.
    return len1 == len2 ? -1 : len;
}