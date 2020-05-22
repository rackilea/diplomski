import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String args[]) {
        String[][] mainArr = new String[][] {{"John Doe - 678DGHJ", "Sport"}, {"Lisa Parker - 432KH3", "Car"}, {"John Doe - 678DGHJ", "Drive"}, {"Peter Bear 4HJ4K3", "Bus"}, {"John Doe - 4HJK4", "Loose"}};

        Arrays.sort(mainArr, new Comparator<String[]>() {
            @Override
            public int compare(String[] entry1, String[] entry2) {
                if (entry1[0].equals(entry2[0])) {
                    return entry1[1].compareTo(entry2[1]);
                }
                return entry1[0].compareTo(entry2[0]);
            }
        });

        for (int i = 0; i < mainArr.length; i++) {
            System.out.println(mainArr[i][0] + ", " + mainArr[i][1]);
        }
    }