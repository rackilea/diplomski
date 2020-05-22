import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Sample {
    private static Scanner s;

    public static void main(String[] args) {
        String n, a[];
        int i, j, k, l;
        System.out.println("Enter the string: ");
        s = new Scanner(System.in);
        n = s.nextLine();
        a = n.split("");
        l = a.length;
        Set<String> noDupes = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < l; i++) {
            noDupes.add(a[i]);
        }
        for (Iterator<String> it = noDupes.iterator(); it.hasNext();) {
            String f = it.next();
            sb.append(f);
        }
        System.out.println(sb.toString());
    }
}