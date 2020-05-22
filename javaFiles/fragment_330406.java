import java.util.Scanner;

    public class Main 
    {
    public static void main(String[] args) 
    {
    Scanner  sc = new Scanner(System.in); //scanner object created
    int ans = 0;

    //Inputs
    System.out.println("Enter your first number");
    int nr1 = sc.nextInt();
    System.out.println("Enter your second number");
    int nr2 = sc.nextInt();
    System.out.println("Enter your sign (+ , - , /, *)");
    String anvin = sc.nextLine();

    if(anvin.equalsIgnoreCase("+")) {
        ans = nr1 + nr2;
    }
    else if(anvin.equalsIgnoreCase("-")) {
        ans = nr1 - nr2;
    }
    else if(anvin.equalsIgnoreCase("*")) {
        ans = nr1 * nr2;
    }
    else if(anvin.equalsIgnoreCase("/")) {
        ans = nr1 / nr2;
    }

   System.out.println(ans);

    }
}

}