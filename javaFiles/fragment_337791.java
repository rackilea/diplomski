import java.util.Collections;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Random;

class Test {
    public static void main(String[] args) {
        int steps = 1000000;    // one million lines

        System.out.print("timeArray: ");
        System.out.println(timeArray(steps));
        System.out.print("timeTree: ");
        System.out.println(timeTree(steps));
    }

    private static long timeArray(int steps) {
        long t1 = System.currentTimeMillis();

        ArrayList<Integer> arr = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < steps; i++) {
            arr.add(rnd.nextInt());
        }
        Collections.sort(arr);

        return System.currentTimeMillis() - t1;
    }

    private static long timeTree(int steps) {
        long t1 = System.currentTimeMillis();

        TreeSet<Integer> tree = new TreeSet<>();
        Random rnd = new Random();

        for (int i = 0; i < steps; i++) {
            tree.add(rnd.nextInt());
        }

        return System.currentTimeMillis() - t1;
    }
}