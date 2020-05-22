import java.io.IOException;
import java.util.Scanner;

public class Switch
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Help on:");
        System.out.println(" 1. if");
        System.out.println(" 2. switch");
        System.out.println("Choose one: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while (!s.equals("0"))
        {
            switch(s)
            {
                case "1":
                    System.out.println("The If");
                    break;
                case "2":
                    System.out.println("The Case");
                    break;
                default:
                    System.out.println("Please choose one");
            }
            s = in.nextLine();
        }
    }
}