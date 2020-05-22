import java.util.Scanner;

public class Test {
public static void main(String[] args) 
{
String keepGoing = "y";
populate(keepGoing);

}

static void populate( String keepGoing){
  Scanner scan = new Scanner(System.in);
 while(keepGoing.equalsIgnoreCase("y")){
     try{
        System.out.println("Enter an integer: ");
        int val = scan.nextInt();
        if (val < 0)
        {
            throw new IllegalArgumentException
            ("value must be non-negative");
        }
        System.out.println("Factorial (" + val + ") = "+ MathUtils.factorial(val));
        System.out.println("Another factorial? (y/n)");
        keepGoing = scan.next();
    }
    catch(IllegalArgumentException i){
        System.out.println("Negative encouneterd. Want to Continue");
        keepGoing = scan.next();
        if(keepGoing.equalsIgnoreCase("Y")){
        populate(keepGoing);
        }
    }
    }
}
}