package basic.functions;
import java.util.*;
import java.io.IOException;
import java.text.DecimalFormat;
public class Percent {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter Integer: ");

        while(reader.hasNextLine())
        {
            String input = reader.nextLine();

            if(input.isEmpty())
            {
                //When user press enter empty
                break;
            }
            else
            {
                try
                {        
                    list.add(Integer.valueOf(input));
                }
                catch (NumberFormatException exception)
                {
                    System.out.println("Not an integer, please try again");
                }
            }
        }

        reader.close();
        //SUM all the integer elements in the list
        int sum = 0;
        for (int x : list)
            sum += x;
        //calculate the percentage of each integer that was entered as proportion of the sum
        //for all elements in the list, divide by the SUM then time 100 to get the percentage
        System.out.println("The numbers and percentage:");
        if (sum == 0) {
            System.out.println("Division by 0 not possible");
        }
        else {
            for (int x : list) {
                System.out.println(x + "               " + ((x * 100 / sum) + "%"));
            }
            System.out.println(sum + "               " + ((sum * 100) / sum) + "%");
        }
    }
}