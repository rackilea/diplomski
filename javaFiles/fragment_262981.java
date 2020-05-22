package languagetranslator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LanguageTranslator {
    // Declare and intitialize some Class global variables...
    // The language. It is also the name of our translation table 
    // text file (ie: spanish.txt)
    private static String language = "spanish";
    // The 2 Dimensional Array which will hold our translation table.
    private static String[][] translationTable = {};


    // Class main() method
    public static void main(String[] args) {
        // Load up the translationTable[][] 2D String Array from our
        // Tanslation Table text file (spanish.txt).
        readInTranslationFile(language + ".txt");

        // Declare and initialize our String variable we will use to accept
        // console input from User with...
        String userInput = "lets go";

        // Open a Connection to console Using the Scanner Class
        try (Scanner conInput = new Scanner(System.in)) {
            // Start a while/loop to continually ask the User to 
            // supply a English word...
            while (!userInput.equals("")) {
                // Ask User to supply a Word...
                System.out.println("\nPlease supply a English word to translate\n"
                        + "or supply nothing to exit:");
                // Hold what User enters into console within the userInput variable.
                userInput = conInput.nextLine();
                // If the User supplied nothing then he/she want to quit.
                if (userInput.equals("")) { break; }

                // Declare and initialize a boolean variable so as to later determine if
                // a translation for the supplied word had been found.
                boolean found = false;
                // Iterate through the translationTable[][] 2D String Array to see if
                // the User's supplied word is contained within. The English word to 
                // match would be in the first column of the array and the translation
                // for that word would be in the second column of the array.
                for (int i = 0; i < translationTable.length; i++) {
                    // convert the word supplied by User and the current word being read
                    // within column 1 of the 2D Array to lowercase so that letter case
                    // is not a factor here.
                    if(userInput.toLowerCase().equals(translationTable[i][0].toLowerCase())) {
                        // If the word supplied by User is found within the translationTable[][]
                        // array then set the found variable to true and display the spanish
                        // translation to console.
                        found = true;
                        System.out.println("--------------------------------------");
                        System.out.println("The " + language + " translation is: \u001B[34m" 
                                + translationTable[i][1] + "\u001B[39;49m");
                        System.out.println("--------------------------------------");
                    }
                }
                // If we've iterated through the entire tanslationTable array and an a match
                // was not found then display as such to the User...
                if (!found) {
                    System.out.println("\n\u001B[31mThe supplied word could not be located within "
                            + "the Translation Table.\n\u001B[39;49m");
                }
                // Continue the while/loop and ask User to supply another word
                // until the User supplies nothing.
            }
        }
        // Exit the application if nothing is supplied by User.
        System.exit(0);
    }


    // Method used to fill the tanslationTable[][] 2D String Array from 
    // a text file which contains all the translation data.
    private static void readInTranslationFile(String filePath) {
        String line = "";
        int cnt = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read in each line of the tanslation Table text file so as to place each
            //line of data into the translationTable[][] 2 String Array...
            while((line = br.readLine()) != null){
                // Skip past blank lines in the text file and only process file lines
                // which actually contain data.
                if (!line.equals("")) { 
                    // Each line of data within the Translation table text file consists
                    // of a |English word and it's Spanish equivalent delimited with a 
                    // Pipe (|) character. A pipe character is used because you may later
                    // want to add definitions to your data that may contain different types 
                    // of punctuation.
                    String[] tok = line.split("\\|");
                    // The redimPreserve() method allows for appending to a raw 2D String 
                    // Array on the fly.
                    translationTable = redimPreserve(translationTable, cnt + 1, 2);
                    // Add the file data line to the 2D String Array...
                    translationTable[cnt][0] = tok[0].trim();
                    translationTable[cnt][1] = tok[1].trim();
                    cnt++; // counter used for incrementing the 2D Array as items are added.
                }
            }
            // Close the BufferReader
            br.close();
        } 
        // Trap IO Exceptions from the Bufferreader if any...
        catch (IOException ex) {
            System.out.println("\n\u001B[31mThe supplied Translation Table file could"
                             + " not be found!\n\u001B[39;49m" + filePath);
        }
    }


    // The redimPreserve() method allows for appending to a raw 2D String 
    // Array on the fly. I created this method to make the task esier to
    // accomplish.
    private static String[][] redimPreserve(String[][] yourArray, int newRowSize, int... newColSize) {
        int newCol = 0;
        if (newColSize.length != 0) { newCol = newColSize[0]; }
        // The first row of your supplied 2D array will always establish
        // the number of columns that will be contained within the entire
        // scope of the array. Any column value passed to this method
        // after the first row has been established is simply ignored.
        if (newRowSize > 1 && yourArray.length != 0) { newCol = yourArray[0].length; }
        if (newCol == 0 && newRowSize <= 1) {
            JOptionPane.showMessageDialog (null,"RedimPreserve() Error\n\n"
                             + "No Column dimension provided for 2D Array!",
                               "RedimPreserve() Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (newCol > 0 && newRowSize < 1 && yourArray.length != 0) {
            JOptionPane.showMessageDialog (null,"RedimPreserve() Error\n\n"
                                + "No Row dimension provided for 2D Array!",
                                  "RedimPreserve() Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String[][] tmp = new String[newRowSize][newCol];
        if (yourArray.length != 0) {
            tmp = Array2DCopy(yourArray, tmp);
        }
        return tmp; 
    }

    // Used within the redimPreserve() method to copy 2D Arrays.
    private static String[][] Array2DCopy(String[][] yourArray, String[][] targetArray) {
        for(int i = 0; i < yourArray.length; i++) {
            System.arraycopy(yourArray[i], 0, targetArray[i], 0, yourArray[i].length);
        }
        return targetArray;
    }
}