import java.io.*;


public class rot13 {

public static void main(String[] args) throws IOException {
    BufferedReader myInput = new BufferedReader(new InputStreamReader(System.in));// Buffered Reader reads the number inputed
    System.out.println("Enter a phrase:");
    String input = myInput.readLine();

    //We loop through every char in the string
    for (char c : input.toCharArray()) {
        //We check if the character is a letter, so we don't add the offset to special characters like space or dot
        if (Character.isAlphabetic(c)) {
            //Here we get the lower case version of the char and remove it 97, which is the ascii value of 'a'
            //With this, we are mapping letters from a to z to numbers from 0 to 25
            char lowerChar = (char) (Character.toLowerCase(c) - 97);
            //We add the offset of 13
            lowerChar += 13;
            //We then use the modulo to move numbers higher than 15 back to the beginning
            lowerChar %= 26;
            //We finally come back to the ascii value of our lower case char
            lowerChar += 97;
            System.out.print(Character.isUpperCase(c) ? Character.toUpperCase(lowerChar) : lowerChar);
        } else {
            //If it's not a letter, we just print the char
            System.out.print(c);
        }
    }

    //We don't forget to close our BuffererReader
    myInput.close();
}
}