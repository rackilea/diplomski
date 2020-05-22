import java.util.Scanner;

public class Exam {
    static int[][] data;
    private static int rows = 0;
    private static int cols = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        enterData(scan);
        countAvg();
    }

    static void enterData(Scanner in) {
        System.out.println("How many rows ?");
        rows = in.nextInt();
        System.out.println("How many cols ?");
        cols = in.nextInt();
        data = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.out.println("Row" + i + ": ");
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter Data for Column " + j + ":");
                data[i][j] = in.nextInt();
            }
        }
    }

    static void countAvg() {
        int total = 0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                total = total + data[i][j];
                count++;
            }
        }
        double avg = total / (double) count;
        System.out.println(count + "the average is: " + avg);
    }
}