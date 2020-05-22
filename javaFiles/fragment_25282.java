public static List<Character> getCharsThatFollowPattern (String text, String pattern)
{
    List<Character> charAfterPattern = new ArrayList<Character>();
    int patternLength = pattern.length();
    int i = 0;
    while (i < text.length())
    {
        int index;
        if ((index = text.indexOf(pattern, i)) < 0) // Check pattern is present
            break;
        i = index + patternLength;
        if (i < text.length()) // Check there is a next character
        {
            charAfterPattern.add(text.charAt(i));
        }
    }
    return charAfterPattern;
}