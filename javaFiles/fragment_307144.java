import java.util.*;

public class MorseCode {

public static void main(String[] args)
{

      Scanner input = new Scanner(System.in);

      String userResponse = "";
      String english = "English";
      String morse = "Morse-Code";
      String morseChars = "";
      String morseMultiWords = "";
      String morseWords = "";
      String phrase = "";
      String answer = "";
      int loop = 0;

      final String[] englishArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                               "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                               "Y", "Z", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

      final String[] morseArray = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                             ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                             "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", " ", 
                             ".----", "..---", "...--", "....-", ".....", "-....", "--...", 
                             "---..", "----.", "-----"};

      while(loop == 0)
      {   
          System.out.print("\nWould you like to enter a phrase in English or in Morse-code? ");
          userResponse = input.next();  


          while(!(userResponse.equalsIgnoreCase(english) || userResponse.equalsIgnoreCase(morse)))
          {
              System.out.println("\nInvalid response. \nPlease enter 'English' or 'Morse-code'.\n");
              System.out.print("Would you like to enter a phrase in English or in Morse-code? ");
              userResponse = input.next();
          }
          if(userResponse.equalsIgnoreCase(english))
          {
              System.out.print("\nPlease enter your English phrase: ");
              input.nextLine();
              phrase = input.nextLine();    

              System.out.println("\nYou entered: " + phrase.toUpperCase());
              phrase = phrase.toUpperCase();
              System.out.print("In morse code, this is: ");

              for(int count = 0; count < phrase.length(); count++ )
              { 
                  for(int index = 0; index < englishArray.length; index++) 
                  { 
                      if(phrase.substring(count, (count+1)).equals(englishArray[index]))
                          System.out.print(morseArray[index] + " "); 
                  } 
              } 
          }

          else if(userResponse.equalsIgnoreCase(morse))
          {
              System.out.print("\nPlease enter your Morse-code phrase: ");
              input.nextLine();
              phrase = input.nextLine();

               String[] morseMultipleWords = phrase.split("   ");

              System.out.println("\nYou entered: " + phrase);
              System.out.print("In English, this is: ");

              for(int i = 0; i < morseMultipleWords.length; i++)
              {
                  morseMultiWords = morseMultipleWords[i];

                  String[] morseCharacters = morseMultiWords.split(" ");

                  for(int j = 0; j < morseCharacters.length; j++)
                  {
                      morseChars += morseCharacters[j];


                      for(int index = 0; index < morseArray.length; index++) 
                      { 
                          if(morseChars.equals(morseArray[index])) 
                              morseWords += englishArray[index];
                      }
                      morseChars = "";
                  }
                  morseWords += " "; 
                  morseMultiWords = "";  
              }
              System.out.println(morseWords); 
          }
          loop++;

          System.out.print("\n\nWould you like to enter another phrase? (Y or N): ");
          answer = input.next();

          while(!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")))
            {
                System.out.print("\nIncorrect input. Please enter either 'Y' or 'N'.");
                System.out.print("Would you like to create 20 sentences? (Y or N): ");
                answer = input.next();  
            }
          if(answer.equalsIgnoreCase("Y"))
          {
              morseWords = "";
              loop = 0;
          }
          else
              {
                System.out.println("Program ended.");
                input.close();
              }

      }
}