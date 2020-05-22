import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        //initialize the scanner.
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //no. of test cases.
        for (int r = 0; r < t; r++) {

            int n = sc.nextInt(); //no. of jobs to be done.
            int m = sc.nextInt(); //no.of jobs already completed.

            ArrayList<Integer> al = new ArrayList<>();
            //add the no. of jobs to be done
            for (int i = 0; i < n; i++) {
                int x = i + 1;
                al.add(x);
            }
            //remove no. of jobs already done
            for (int i = 0; i < m; i++) {
                int q = sc.nextInt();
                Integer a = new Integer(q);
                al.remove(a);
            }

            //print jobs to be done by chef
            for (int i = 0; i < al.size(); i += 2) {
                System.out.print(al.get(i) + " ");
            }
            System.out.println();
            //print jobs to be done by asst.
            for (int i = 1; i < al.size(); i += 2) {
                System.out.print(al.get(i) + " ");
            }
            System.out.println();
            al.clear();

        }

    }

}