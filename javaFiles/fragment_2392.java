import java.util.*;
public class Main {

    public static void main(String[] args) {            
        Scanner scan = new Scanner(System.in);
        int amount = 0;
        int total = 0;

        // Create a Map to get the count of each input.
        Map<Integer,Integer> counts = new TreeMap<Integer,Integer>();

        System.out.println("How many numbers do you plan to enter?");
        amount = scan.nextInt(); 
        for(int x = 0; x<amount; x++)
        {
            System.out.println("Enter a number");
            int input = scan.nextInt();
            if (counts.containsKey(input)) counts.put(input, counts.get(input) + 1);
            else counts.put(input,1);
        }

        // Print out the percentage of each input
        for (Integer key : counts.keySet())
            System.out.printf("%d\t%.2f%%\n", key, counts.get(key) * 100.0 / amount);
    }
}