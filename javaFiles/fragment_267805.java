import java.util.*;
class UserInputReader {

    private static final int EXPECTED_NUM_COUNT = 3;

    public static void main(String[] args) {
        String [] i = { "zero" , "one" , "two" , "three" , "four" , 
                    "five", "six", "seven" , "eight" , "nine" , "ten" };

        Scanner in = new Scanner (System.in);   
        String[] words = new String[EXPECTED_NUM_COUNT];

        int numCount = 0;
        while(numCount < 3) {
            System.out.println("Enter the number");
            int num = in.nextInt();
            if (num >= 0 && num <= 10) {
                words[numCount] = i[num];
                numCount++;
            } else {
                System.out.println("Enter no is invalid. Try again entering a number between 0 - 10");
            }
        }

        System.out.println("Entered nums " + Arrays.toString(words));

    }
}