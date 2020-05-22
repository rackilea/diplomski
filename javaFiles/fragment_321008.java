import java.util.Arrays;
import java.util.Comparator;

public class MyCmp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] parts1 = o1.split("\\.");
        String[] parts2 = o2.split("\\.");
        int max = Math.max(parts1.length, parts2.length);
        for (int i = 0; i < max; i++) {
            if (i < parts1.length && i < parts2.length) {
                Integer i1 = Integer.parseInt(parts1[i]);
                Integer i2 = Integer.parseInt(parts2[i]);
                if (i1 == i2)
                    continue;
                return i1.compareTo(i2);
            }
            if (i < parts1.length) {
                return 1;
            }
            if (i < parts2.length) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] menuIndex = { "0",
                "1",
                "2",
                "3",
                "0.0",
                "0.0.1",
                "0.0.0",
                "0.0.4",
                "14",
                "14.0",
                "0.1" };
        Arrays.sort(menuIndex, new MyCmp());
        System.out.println(Arrays.toString(menuIndex));
    }

}