public static void wordBox(String words, int wordsPerLine) {
    int count = 1;
    for (int i = 0; i < words.length(); i++)
    {
    if (words.charAt(i) == ' ' && (count++) % wordsPerLine == 0)
        System.out.println();               
    else 
        System.out.print(words.charAt(i));
    }
    System.out.println();
}