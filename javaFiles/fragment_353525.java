import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT.
     * Your class should be named Solution.
     */
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    ArrayList array[] = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        ArrayList list = new ArrayList();
        Scanner linSc = new Scanner(sc.nextLine());
        while (linSc.hasNextInt()) {
            list.add(linSc.nextInt());
        }
        linSc.close();
        array[i] = list;
    }
    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        int k = sc.nextInt();
        int l = sc.nextInt();
            try {
                System.out.println(array[k - 1].get(l));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
        sc.close();
    }
}