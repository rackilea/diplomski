private static String scramble(char first, char last, String word)
{
    String shuffledString = "" + first; // <-- add the first char
    while (word.length() != 0)
    {
        int index = (int) Math.floor(Math.random() * word.length());
        char c = word.charAt(index);
        word = word.substring(0,index)+word.substring(index+1);
        shuffledString += c;
    }
    return shuffledString + last; // <-- add the last char
}