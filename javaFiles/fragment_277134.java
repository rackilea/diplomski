public static void main(String[] args)
{
    String line = "ALONE AMEND DATES DAWNS DEALS LEMON LENDS";
    for (int maxVowelAtChar = 1; maxVowelAtChar < 6; maxVowelAtChar++)
    {
        String pure = myFunc(line, maxVowelAtChar);
        System.out.println(maxVowelAtChar + ": " + pure);
    }
}

private static String myFunc(String line, int maxVowelAtChar)
{
    String pure = "";

    for (String word : line.split("\\s"))
    {
        // This regex is also sensitive to word length ie not being 5 like all test data
        if (word.matches("^.{" + (word.length() - maxVowelAtChar + 1) + "}[^aeiouAEIOU]*$"))
            pure += word + " ";
    }

    return pure.trim();
}

Output:
1: ALONE AMEND DATES DAWNS DEALS LEMON LENDS
2: AMEND DATES DAWNS DEALS LEMON LENDS
3: AMEND DAWNS DEALS LENDS  
4: DAWNS LENDS
5: