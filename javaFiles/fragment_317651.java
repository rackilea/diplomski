public static int startingRepeats(final String haystack, final String needle)
{
    String s = haystack;
    final int len = needle.length();

    // Special case...
    if (len == 0)
        return 0;

    int count = 0;

    while (s.startsWith(needle)) {
        count++;
        s = s.subString(len);
    }

    return count;
}