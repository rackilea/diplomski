import java.util.Scanner;


    class Increase
    {
     public static void main (String [] args)
     {
       Scanner in = new Scanner(System.in);
       final int Days = 10;
       int highval = 0;
       int lowval = 0; 
       int increase = 0; 
       int day = 0;
       System.out.print("Enter the stock prices for " + Days + " number of days.");
       int x = in.nextInt();

       for (int i = 0; i < Days-1; i++)
       {
        int y = in.nextInt();
         if (increase < (y - x))
         { 
           increase = (y - x);
           highval = y;
           lowval = x;
           day = i; 
         }
        x = y;
       }    

       System.out.println("The largest increase is " + increase);
       System.out.println("from  " +lowval + " to " + highval );
       System.out.println("between days " + day + " and " + (day + 1));
     }
    }