package stackoverflow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    static Pattern p = Pattern.compile("(\\d+)d (\\d+)h (\\d+)m (\\d+)s");

    private static void add(String s, int[] a) {
        Matcher m = p.matcher(s);
        m.find();       
        for (int i = 0; i < a.length; i++)
            a[i] += Integer.parseInt(m.group(i + 1));
    }

    private static String calculate(String s1, String s2) {
        int a[] = new int[4];
        add(s1, a);
        add(s2, a);
        if (a[3] >= 60) {
            a[3] -= 60;
            a[2]++;
        }
        if (a[2] >= 60) {
            a[2] -= 60;
            a[1]++;
        }
        if (a[1] >= 24) {
            a[1] -= 24;
            a[0]++;
        }
        return String.format("%dd %dh %dm %ds", a[0], a[1], a[2], a[3]);
    }

    public static void main(String args[]) {
        String s1 = "11d 24h 13m 12s";
        String s2 = "1d 0h 0m 3s";
        System.out.println(calculate(s1, s2));
    }
}