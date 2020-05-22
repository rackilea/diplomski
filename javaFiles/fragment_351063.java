import java.io.StringReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new StringReader("2\naab\naac\n"));

        int cases = Integer.parseInt(in.nextLine());
        String[] a = new String[cases];
        //int i, c;

        // Adding directly to the Set prevents a larger list because you remove
        // the duplicates
        Set<String> set = new TreeSet<String>();

        for (int i = 0; i < cases; i++) {
            a[i] = in.nextLine();
            for (int c = 0; c < a[i].length(); c++) {
                for (int ii = 1; ii <= a[i].length() - c; ii++) {
                    String sub = a[i].substring(c, c + ii);
                    set.add(sub);
                }
            }
        }
        System.out.println(set);
    }
}