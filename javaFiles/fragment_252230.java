1. Use the Scanner(File) constructor.
2. Use a loop that is, essentially this:
    a. Scanner blam = new Scanner(theInputFile);
    b. Map<String, Integer> wordMap = new HashMap<String, Integer>();
    c. Set<String> wordSet = new HashSet<String>();
    d. while (blam.hasNextLine)
    e. String nextLine = blam.nextLine();
    f. Split nextLine into words (head about the read String.split() method).
    g. If you need a count of words: for each word on the line, check if the word is in the map, if it is, increment the count.  If not, add it to the map.  This uses the wordMap (you dont need wordSet for this solution).
    h. If you just need to track the words, add each word on the line to the set.  This uses the wordSet (you dont need wordMap for this solution).
3. that is all.