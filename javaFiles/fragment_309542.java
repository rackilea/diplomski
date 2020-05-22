public static void getFileAndFrequency() throws FileNotFoundException
{
    File plaintext = new File("subplaintext");
    Scanner inFile = new Scanner(plaintext);

    while (inFile.hasNext()) //is true when the document has another word following the previous
    {   
        String[] lettersToCompare = inFile.next().toLowerCase().split("(?!^)"); //splits the specified word into a String array

        for (int i = 0; i < 26; i++) //specifies the index of alphabet (the letter the program is looking for)
        {
            for (int stringIndex = 0; stringIndex < lettersToCompare.length; stringIndex++) //loops through the index (individual letters) of the split word
            {
                if (lettersToCompare[stringIndex].equals(alphabet[i])) //if letter specified in split word equals letter specified in alphabet
                {
                    alphabetFrequency[i]++; //add one to the frequency array in the same index as the index in alphabet
                }
            }
        }   
    }
}