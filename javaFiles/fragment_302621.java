import java.util.Scanner;

public class test {


// this function should be static
public static int attempt (int b) {
        //b for entry, since b is the name of the variable
        return 3 + b;
}


public static void main (String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println ("Enter single digit int ");
        int entry = keyboard.nextInt();

        //put this in your main function
        int r = attempt(entry);
        System.out.println("Your number is " + entry);
        System.out.println("Your number is " );

        System.out.println("The final result is " + r);

        }
}