import java.util.Scanner;

public class SO_Example_20151205_01 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String pattern = "[0-9]{2}:[0-9]{2}";   // The pattern you'll use to validate if the time is valid
        String time;                            // The input variable
        boolean valid_time = false;             // A flag to break the loop. Initialized to false
        int hour, minute;

        // I prefer to use a 'while' loop in this case.
        // The loop will break if the valid_time variable is true
        while(!valid_time) {
            System.out.print("Enter time (HH:MM):\t");
            time = console.next();
            // Check if the input matches the pattern:
            if(time.matches(pattern)) {
                // Now, check if the input values are valid
                hour = Integer.parseInt(time.substring(0,2));
                minute = Integer.parseInt(time.substring(3,5));
                if(hour >= 0 && hour <= 24 && minute >= 0 && minute < 60) {
                    valid_time = true;
                } else {
                    System.out.println("\nYou've entered a valid pattern, but the values are invalid!\n Please try again");
                }
            } else {
                System.out.println("\nYou entered a non recognized pattern. Please try again\n");
            }
        }
        System.out.println("Done!");
    }
}