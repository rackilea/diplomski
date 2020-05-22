import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ReadChar {

    public ReadChar() {
        // TODO Auto-generated constructor stub
    }

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        boolean opt1Done = false;

        while (true) {

            System.out.println("Select your next step");
            System.out.println("1: Enter three numbers between 1 and 100.");
            System.out.println("2: Order your number in ascending order");
            System.out
                    .println("3: Determine if the three inputs form a triangle");
            System.out.println("4: Exit");

            int answer = console.nextInt();

            if (answer == 1) {
                // do whatever for option 1
                System.out.println("Enter a value for num1 between 1 and 100.");
                num1 = console.nextInt();

                System.out.println("Enter a value for num2 between 1 and 100.");
                num2 = console.nextInt();
                System.out.println("Enter a value for num3 between 1 and 100.");
                num3 = console.nextInt();

                opt1Done = true;
            } else if (answer == 2) {
                if (opt1Done) {
                    // ...... do whatever to order the numbers
                    int[] arraynum;
                    arraynum = new int[3];

                    arraynum[0] = num1;
                    arraynum[1] = num2;
                    arraynum[2] = num3;

                    Arrays.sort(arraynum);

                    int i;

                    for (i = 0; i < arraynum.length; i++) {
                        System.out.println("num:" + arraynum[i]);
                    }

                } else {
                    System.out
                            .println("you must complete Step 1 before Step 2");
                }
            } else if (answer == 3) {
                if (opt1Done) {
                    // ... do whatever to determine if triangle or not
                    if (num1 + num2 > num3 && num1 + num3 > num2
                            && num2 + num3 > num1) {
                        System.out.print("TRIANGLE");
                    } else {
                        System.out.print("NO TRIANGLE");
                    }

                } else {
                    System.out
                            .println("you must complete Step 1 before Step 3");
                }

            }
            if (answer == 4) {
                System.exit(0);

            }
        }
    }
}