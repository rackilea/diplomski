import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomPicker {

    public static void main(String[] args) {

        int[] arr = {6, 1, 5, 3, 4, 2};
        Random random = new Random();
        Set<Integer> randoms = new HashSet<>();
        while (arr.length != randoms.size()) {
            int i = nextRandomIndex(arr, random, randoms);
            int j = nextRandomIndex(arr, random, randoms);
            System.out.printf("%d,%d\n", arr[i], arr[j]);
        }
    }

    private static int nextRandomIndex(int[] arr, Random random, Set<Integer> randoms) {
        int i = random.nextInt(arr.length);
        while (randoms.contains(i)) {
            i= random.nextInt(arr.length);
        }
        randoms.add(i);
        return i;
    }
}