import java.util.Scanner;

public class EP54
{
   public static void main(String[] args)
   {
       Scanner in = new Scanner(System.in);    
       System.out.print("Do you want to continue? ");
       String answer = in.next();
       yesNoChecker(answer);
   }

   public static void yesNoChecker(String in)
   {
       if(in.equalsIgnoreCase("y") ||
         in.equalsIgnoreCase("yes") ||
         in.equalsIgnoreCase("Sure") ||
         in.equalsIgnoreCase("why not"))
         System.out.println("OK");
       else if(in.equalsIgnoreCase("n") ||
         in.equalsIgnoreCase("no") ||
         in.equalsIgnoreCase("nope") ||
         in.equalsIgnoreCase("quit"))
         System.out.println("Terminating.");
       else
         System.out.println("Bad Input");;
   }
}