public static Map<Char,Integer> getFileAndFrequency() throws FileNotFoundException
{
    Map<Char,Integer> frequencyMap = new HashMap<Char,Integer>();
    File plaintext = new File("subplaintext");
    Scanner inFile = new Scanner(plaintext);

    while (inFile.hasNext()) //is true when the document has another word following the previous
    {   
        String[] lettersToCompare = inFile.next().toLowerCase().split("(?!^)"); //splits the specified word into a String array

        for (int stringIndex = 0; stringIndex < lettersToCompare.length; stringIndex++) //loops through the index (individual letters) of the split word
        {
            char ch = lettersToCompare[stringIndex].charAt(0);
            Integer frequency = frequencyMap.get(ch);
            if (frequency ==null) {
               frequency = 0;
            }
            frequency += 1;
            frequencyMap.put(ch, frequency);
        }   
    }
    return frequencyMap;
}