public static void getFileAndFrequency() throws FileNotFoundException
{
    File plaintext = new File("subplaintext");
    Scanner inFile = new Scanner(plaintext);

    while (inFile.hasNext()) //is true when the document has another word following the previous
    {   
        String[] lettersToCompare = inFile.next().toLowerCase().split("(?!^)"); //splits the specified word into a String array

        for (int stringIndex = 0; stringIndex < lettersToCompare.length; stringIndex++) //loops through the index (individual letters) of the split word
        {
            char ch = lettersToCompare[stringIndex].charAt(0);
            if (ch >= 'a' && ch <= 'z')
                alphabetFrequency[ch-'a']++; //add one to the frequency array in the same index as the index in alphabet
        }   
    }
}