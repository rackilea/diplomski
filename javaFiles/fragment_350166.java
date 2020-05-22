public static void main(String[] args)
{
    // you can gather these entries from a Scanner, or whatever
    final String inp = "Spring is Amazingly Beautiful for Ana";
    final int len = 3;


    String[] words = extractWords(inp);
    for (String word : words) {
        if (correctLength(word, len) && startsWithVowel(word)) {
            System.out.println(word);
        }
    }
}

public static String[] extractWords(final String sentence)
{
    return sentence.split("[\\s]+");
}

public static boolean correctLength(String word, int expLen)
{
    return word.length() == expLen;
}

public static boolean startsWithVowel(final String word)
{
    if (word == null || word.isBlank()) {
        return false;
    }

    boolean startsWith = false;



    // really need to develop a comprehensive approach to what is a vowel
    // could use regular expressions,
    //
    // return word.matches("(?i)^[aeiou].*$");
    //
    // but it is slightly easier if 
    // just use a known set since there are more than aeiou in the world
    // also, we will set to lower case, so can use smaller set
    switch (word.toLowerCase().charAt(0)) {
    case 'a':
    case 'e':
    case 'i':
    case 'o':
    case 'u':
        startsWith = true;
        break;

    default:
        break;
    }

    return startsWith;
}