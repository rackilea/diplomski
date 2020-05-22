final static String vowels = "aeiouy";
public static int indexOfFirstVowel(String word){
    String loweredWord = word.toLowerCase();

    for (int index = 0; index < loweredWord.length(); index++)
    {
        if (vowels.contains(String.valueOf(loweredWord.charAt(index))))
        {
            return index;
        }
    }

    // handle cases where a vowel is not found
    return -1;
}