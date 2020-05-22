import java.util.ArrayList;
import java.util.Scanner;

public class IncreasingSum {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = kb.nextInt();
        ArrayList<Integer> myList = new ArrayList<Integer>();

        for (int loop = 0; loop < num; loop++) {
            myList.add(loop);
        }
    }
}