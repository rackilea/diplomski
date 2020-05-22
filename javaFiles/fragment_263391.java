import java.util.Scanner;

/**
 * Creates the secret code class.
 * 
 * @author Stephen Roland
 * 
 */
 class SecretCode {
    /**
     * Perform the ROT13 operation
     * 
     * @param plainText
     *            the text to encode
     * @return the rot13'd encoding of plainText
     */

    public static String rotate13(String plainText) {
        StringBuffer cryptText = new StringBuffer("");
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            currentChar = (char)((char)(currentChar-'A' + 13)%26 + 'A');
            cryptText.append(currentChar);


        }
        return cryptText.toString();

    }

    /**
     * Main method of the SecretCode class
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (1 > 0) {
            System.out.println("Enter plain text to encode, or QUIT to end");
            Scanner keyboard = new Scanner(System.in);
            String plainText = keyboard.nextLine();
            if (plainText.equals("QUIT")) {
                break;
            }
            //String cryptText = SecretCode.rotate13(plainText);
            String encodedText = SecretCode.rotate13(plainText);

            System.out.println("Encoded Text: " + encodedText);
        }

    }

}