import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Properties properties = new Properties();
        properties.setProperty("A2", "Smith");
        properties.setProperty("C3", "Jones");

        String[] rows = { "A", "B", "C", "D" };
        int seats = 4;

        for (int row = 0; row < rows.length; row++)
        {
            for (int seat = 1; seat <= seats; seat++)
            {
                String key = rows[row] + seat;
                String property = properties.getProperty( key );

                System.out.println(key + " : " + property);
            }
        }


    }
}