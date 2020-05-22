private static void displayResult(String string1, String string2)
{
    boolean[] contains = new boolean[26];
    boolean noSubstring = true;

    // populate the contains array
    for (char c : string1.toCharArray())
    {
        int value = (int)c - (int)'a';    // make the char 0-25
        contains[value] = true;
    }

    for (char c : string2.toCharArray())
    {
        int value = (int)c - (int)'a';    // make the char 0-25

        if (contains[value])
        {
            noSubstring = false;
            break;
        }
    }

    if (noSubstring)   System.out.println("NO");
    else               System.out.println("YES");
}