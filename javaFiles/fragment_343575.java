import java.util.*;

public class MyClass 
{

 public static void main(String []args)
 {
   new_guess();

}


static void new_guess()
{
    int correct_answer = 7;
    Scanner scn = new Scanner(System.in);

    System.out.println("Enter a Number from 1 to 10: ");
    int guess = scn.nextInt();

    if(correct_answer != guess)
    {
        if(correct_answer < guess)
        {
        System.out.println("Guess Lower...");
        }
        else if (correct_answer > guess) 
        {
            System.out.println("Guess Higher...");
        }
        new_guess();
    }
    else
    {
          System.out.println("Correct Guess!");
    }

}