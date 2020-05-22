import java.util.*;

public class P1D{

    public static void main (String args[]) {
        boolean error = false;
        String randString;
        System.out.println("Number|Power|Between");

       for(int i = 1; i <= 10; i++)
       {
            int numbersq = i*i; //square of numbers
            Random rand = new Random();

            //random number between number & square (inclusive)
            int random = (rand.nextInt((numbersq - i) + 1) + i);

            //prevents random from being over 1
            if (i == 1)
                random = 1;

            //if random is out of bounds, displays an error
            if (random > numbersq || random < i) {
                error = true;
                randString = (String.valueOf(random) + "   <-- ERROR");
            }
            //notifies me of errors if random is out of bounds

            //if no error, random isn't changed and error=false
            else {
                error = false;
                randString = String.valueOf(random);
            }
            System.out.println(i + "\t" + numbersq + "\t" + randString);
        }

        if (!error) {
            System.out.println("all good in the hood");
        } else {
            System.out.println("Something went wrong");
        }

    }
}