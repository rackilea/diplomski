public void findMatches(String A, String B, ArrayList<Character> matches, ArrayList<Character> unmatches)
{
    String D = B;
    int i = 0;
    while (i++ < 5)
    {
        char charToMatch = A.charAt(i);
        if (D.indexOf(charToMatch) == -1) 
        {
            unmatches.add(charToMatch);
        }
        else
        {
            matches.add(charToMatch);
            // replace the first occurrence of charToMatch with empty
            D = D.replaceFirst("[" + charToMatch + "]", "");
        }
    }
}