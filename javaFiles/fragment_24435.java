import java.util.*;

public class Main {
    public static void main (String []args) {

        int []randomNumArray = new int [6];

        randomNumArray[0] = randomNumber();

        System.out.println(randomNumArray[0]);


        for (int i = 1; i < 6; i++)
        {                   
            int candidate;
            boolean foundMatch;
            do
            {
                candidate = randomNumber();
                foundMatch = false;
                for (int j = 0; j < i; j++)
                    if (candidate == randomNumArray[j])
                        foundMatch = true;
            } while (foundMatch);
            randomNumArray[i] = candidate;

            System.out.println(randomNumArray[i]);
        }
    }
    //This method is for generating random numbers
    public static int randomNumber (){
        return  ( 1 + (int) (Math.random() * 49) );
    }
}