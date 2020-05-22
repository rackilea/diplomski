import java.util.Scanner;

public class SixTwo {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // int[] nums = new int[51];


    //You need to change the initial data of the occur array to zero
    int[] occur = { 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0 };

    int[] nums = { -25, -24, -23, -22, -21, -20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6,
            -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
            23, 24, 25 };

    for (;;) {
        System.out.println("Enter an integer between -25 to 25 (00 to quit)");
        //You need to take input as String other wise you will not be able to find whether user enter 00
        String input = sc.next();
        if(input.equals("00")){
            break;
        }

        int n = 0;

        try {
            n=Integer.valueOf(input);
        } catch (Exception e) {
            continue;
        }

        //You need to add check whether entered number out of range 
        if (n > 25 || n<-25) {
            System.out.println("Out of range");
            continue;
        }

        occur[25+n] = occur[25+n]+1;
    }

    System.out.println("All Occurrences: ");
    for (int i = 0; i < nums.length; i++) {
        System.out.println(nums[i] + ":"+occur[i]);
    }
    System.out.println();

    sc.close();
}
}