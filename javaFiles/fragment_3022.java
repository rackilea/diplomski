import java.util.*;
class huge_addition
{
public static void main (String[] args)
{
Scanner sc = new Scanner (System.in);
System.out.println ("Enter numbers. List terminates when you enter a zero. Enter a zero when you want to begin the addition.");

// no need ->> int a = sc.nextInt();
int num=-1;
int esum=0;
int osum=0;
int nsum=0;
while (num !=0)
{

    System.out.println("enter the number");
       num= sc.nextInt();
        if (num%2==0)
        {
            esum = esum+num;
        }// end of 3rd innermost if statement
        else
        {
        osum = osum+num;
        }// end of 3rd else statement
    //end of 2nd middle if-else-loop
    if (num<0)
    {
        nsum=nsum+num;
    }//end of 2nd middle else statement
 }//end of while loop
    System.out.println ("The sum of even positive numbers is "+esum);
    System.out.println ("The sum of odd positive numbers is "+osum);
    System.out.println ("The sum of negative numbers is "+nsum);
 }//end of main
    }//end of class