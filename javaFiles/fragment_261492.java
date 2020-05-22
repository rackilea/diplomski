import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Commander
{
    public static void main(String[] args)
    {
        Map<String,Integer> expression = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        String Variable , assignmentOperator;
        int Value;

        while(sc.hasNextLine())
       {

            Variable = sc.nextLine();
            assignmentOperator = sc.nextLine();
            Value = Integer.parseInt(String.valueOf(sc.nextInt()));

            expression.put(Variable,Value);

            for(String key: expression.keySet())
                System.out.println(key + " - " + expression.get(key));
        }
    }
}