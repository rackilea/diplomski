import java.util.*;
public class Main {    

    public static void main(String[] args) {            
        Scanner scan = new Scanner(System.in);
        int amount = 0;
        int total = 0;

        System.out.println("How many numbers do you plan to enter?");
        amount = scan.nextInt(); 
        // Now that we know the amount, we can build an array to hold that
        // amount.
        int[] numbers =  new int [amount]; 
        for(int x = 0; x<amount; x++)
        {
            System.out.println("Enter a number");
            numbers[x] = scan.nextInt();
            total += numbers[x];
        }
        double average = total * 1.0 /amount; // Prevent integer division
        System.out.println(average);
    }
}