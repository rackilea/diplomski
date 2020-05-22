import java.util.*;
public class Multi_Line_Input
{
public static void main(String [] args)
{
    Scanner s = new Scanner(System.in);
    System.out.println("Please enter the inputs");
    List<String> l = new ArrayList<String>();
    while(s.hasNext())
    {
        String line = s.nextLine();

        if (line.equalsIgnoreCase("exit")) {
            break;
        }

        l.add(line);
    }
    Iterator i = l.iterator();
    while(i.hasNext())
    {
        System.out.println((String)i.next());
    }
}

}