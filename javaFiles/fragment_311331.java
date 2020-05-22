import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        System.out.println("Type");

        Scanner reader = null;

        try {

            // Read from System.in
            reader = new Scanner(System.in);

            // Only work with first character
            char c = reader.findInLine(".").charAt(0);

            // ""+c creates a string since RegEx only works on strings
            String testString = ""+c;

            // Test string
            if(!(""+c).matches("[a-fA-F]")) {
                System.out.println("Invalid input");
                return;
            }

            // c has a valid grade
            System.out.println("Valid input");      
        }
        catch(Exception ex) {
            if(reader != null)
                reader.close();
        }
    }   
}