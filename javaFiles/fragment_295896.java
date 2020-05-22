if (j.equals(" ")) // <== No semicolon, and no == true
{
    lastWord = word.substring(i);
    System.out.println("Last word: " + lastWord);
    i = -1; //to stop the loop
}