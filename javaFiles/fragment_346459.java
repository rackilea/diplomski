public static void wordList()
{
    Scanner keyboard = new Scanner(System.in);

    final String word = keyboard.next(); // <-- this is the current word.
    if (word.equalsIgnoreCase("STOP")) 
        System.out.println();
    else
        wordList(); // <-- it's not STOP, recurse... which 
                    //     will get a new local word (and print it).
    System.out.println(word); // <-- however, this is still current word.
}