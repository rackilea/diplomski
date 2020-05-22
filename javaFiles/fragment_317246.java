import javax.swing.*;

public class Main {

    public static void main(String[] args) 
    {
        int i; 
        int n; //here is your number (say 20) and you need all primes below 20
        int number; // it will loop through all numbers between 2 to n
        boolean nPrime=true;
        n = Integer.parseInt(JOptionPane.showInputDialog("Entrer un numero"));

        for ( number = 2 ; number <= n ; ++number ) // for outer
        {
            for (i = 2; i < number; i++) //for inner
            /*from here it is simply your code which checks every number
            for primeness, BTW you need to check for only upto
            square_root(number) so change your code to i*i < number, I
            didn't changed it just to make it as similar to yours as
            possible
            */
            {
                if (number % i == 0) 
                {
                    nPrime = false;
                }
            }//for inner closed

            if (nPrime) 
            {
                System.out.println("Le numero " + number + " est prime");
            } 
            else
                System.out.println("Le numero " + number + " n'est pas prime");
                //if you need only primes then remove this else part
            nPrime=true;
        }//for outer closed
    }// main() closed
}//class closed