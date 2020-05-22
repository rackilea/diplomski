import java.util.Arrays;
import java.util.Comparator;


public class demo_sort {

    public static void main(String[] args) {

        final String[][] data = new String[][] {
                new String[] {"bob","one"},
                new String[] {"jack","two"},
                new String[] {"adam","three"}
                };

        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });

        for (final String[] s : data) {
            System.out.println(s[0] + " " + s[1]);
        }

    }

}