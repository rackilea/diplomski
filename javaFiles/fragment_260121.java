package casino;

import java.util.*;

public class Actions {
    private static final Random rnd = new Random();

    /** Fisher–Yates shuffle */
    public static <E> void shuffle(List<E> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            E tmp = list.get(index);
            list.set(index, list.get(i));
            list.set(i, tmp);
        }
    }

    public static <E extends Comparable<E>> void sort(List<E> list) {
        Collections.sort(list);
    }
}