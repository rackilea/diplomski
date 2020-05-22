import java.util.Scanner;

public class CheckBinaryInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        String userInput = "";
        do {
            System.out.print("Please Enter a binary integer: ");
            userInput = sc.next();
            isValid = userInput != null && !userInput.trim().isEmpty() 
                      && userInput.matches("[01]{1,32}");//assume every digit as one bit 
            if(!isValid)
                System.out.println("invalid binary integer entered! ");
        }while(!isValid);

        System.out.println("Valid input: "+userInput);
    }
}