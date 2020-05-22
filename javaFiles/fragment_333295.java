import java.io.IOException;

public class Switch
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Help on:");
        System.out.println(" 1. if");
        System.out.println(" 2. switch");
        System.out.println("Choose one: ");
        char ch = (char)System.in.read();
        while (ch!= '0')
        {
            switch(ch)
            {
                case '1':
                    System.out.println("The If");
                    break;
                case '2':
                    System.out.println("The Case");
                    break;
                default:
                    System.out.println("Please choose one");
            }
            ch = (char)System.in.read();
            ch = (char)System.in.read();
        }

    }
}