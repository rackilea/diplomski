public static String[] generateRandomWords(int numberOfWords)
{
    String[] randomStrings = new String[numberOfWords];
    Random random = new Random();
    for(int i = 0; i < numberOfWords; i++)
    {
        char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
        for(int j = 0; j < word.length; j++)
        {
            word[j] = (char)('a' + random.nextInt(26));
        }
        randomStrings[i] = new String(word);
    }
    return randomStrings;
}