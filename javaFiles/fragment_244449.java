import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        String input = null;
        String compareString = "hello world";
        Scanner inputReader = new Scanner(System.in);
        System.out.println("please enter: hello world" );

        // here is how you take the input from keyboard

        input = inputReader.nextLine();
                // this is how you write to console
        System.out.println("You entered :" + input);

        //Here is how you compare two string
        if(compareString.equals(input))
        {
            System.out.println("input is: hello world");
        }
        else
        {
            System.out.println("input is not: hello world");
        }
    }
}