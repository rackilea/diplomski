if (word.charAt(i) == ' ') // Single quotes mean one character
{
    lastWord = word.substring(i+1);
    System.out.println("Last word: " + lastWord);
    break; // there is a better way to stop the loop
}