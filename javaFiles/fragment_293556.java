BufferedReader fileReader = new BufferedReader(new FileReader(new File("par.txt")));

String allCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
String aLineInFile;

// Read the file that was written earlier (whose content comes from user input)
// This while loop will go through line-by-line in the file
while((aLineInFile = fileReader.readLine()) != null)
{
      // For every line in the file, count number of occurrences of characters  
      // This loop goes through every character (a-z and A-Z)  
      for(int i = 0; i < allCharacters.length(); i++)
      {
            // For each single character, check the number of occurrences in the current line
            String charToLookAt = String.valueOf(allCharacters.charAt(i));
            int numOfCharOccurancesInLine = countLetters (aLineInFile, charToLookAt);

            System.out.println("For line: " + aLineInFile + ", Character: " + charToLookAt + " appears: " + numOfCharOccurancesInLine + " times " );
      }         
}