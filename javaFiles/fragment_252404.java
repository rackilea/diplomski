public static String expand(String word)
{
    if (word.length() <= 1)
    {
        // My end state: the input string has 0 or 1 characters - no way to add hyphens!
        return word;
    }
    else
    {
        // Return the first character of word, a hyphen, and the result of the recursive algorithm
        return word.substring(0, 1) + "-" + expand(word.substring(1));
    }
}