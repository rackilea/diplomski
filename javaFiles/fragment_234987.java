import java.util.Scanner;

public class SumOfOddEven {    
    public static void main(String[] args) {
        int sumOddInts = 0, sumEvenInts = 0, countOddInts = 1, countEvenInts = 10;
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.println("Count: " + i + ", enter an integer (from 1 to 10): ");
            int number;
            do {
                number = in.nextInt();
                if (!(number >= 0 && number <= 10)) {
                    System.out.println("Try again, enter an integer (from 1 to 10): ");
                } else {
                    if (number % 2 == 0) {
                        sumEvenInts += power(number, countEvenInts--);
                    } else {
                        sumOddInts += power(number, countOddInts++);
                    }
                }
            } while (!(number >= 0 && number <= 10));
        }
        in.close();
        System.out.println("The sum of even powered: " + sumEvenInts);
        System.out.println("The sum of odd powered: " + sumOddInts);
    }

    static int power(int n, int power) {
        int num = 1;
        for (int i = 1; i <= power; i++) {
            num *= n;
        }
        return num;
    }
}