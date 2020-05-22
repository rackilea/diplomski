package bar;
import java.util.Scanner;

import foo.pkg.ThatClass;

public class ThisClass {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            String answer = "";

            System.out.print("Please enter Y or N: ");
            answer = in.next();

            if (answer.toUpperCase().equals("Y"))
                // Call another class' main function.
                ThatClass.main(null);
            else {
                System.out.println("You entered the wrong value.");
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}