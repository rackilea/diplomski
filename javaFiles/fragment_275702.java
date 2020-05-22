import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortCompare {
    public static void main(String[] args) {
        int tests = 2;
        int runs = 10;
        int size = 6; // 1 -> 100,000
        long[][][] times = new long[tests][size][runs];
        double[][] avgs = new double[tests][size];

        for (int run = 0; run < runs; run++) {
            System.out.printf("Run #%d...%n", run);

            for (int magnitude = 0; magnitude < size; magnitude++) {
                System.out.printf("Magnitude #%d...%n", magnitude);

                int[] a = shuffle(range((int) Math.pow(10, magnitude)));
                {
                    long start = System.currentTimeMillis();
                    insertionSort(Arrays.copyOf(a, a.length));
                    times[0][magnitude][run] = System.currentTimeMillis() - start;
                }

                {
                    long start = System.currentTimeMillis();
                    sort(Arrays.copyOf(a, a.length));
                    times[1][magnitude][run] = System.currentTimeMillis() - start;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < tests; j++) {
                avgs[j][i] = avg(times[j][i]);
            }
        }

        System.out.printf("insertionSort : %s%n", Arrays.toString(avgs[0]));
        System.out.printf("         sort : %s%n", Arrays.toString(avgs[1]));
    }

    private static double avg(long[] times) {
        long total = 0;
        for (long time : times) total += time;
        return ((double) total) / times.length;
    }

    private static int[] range(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) a[i] = i;
        return a;
    }

    private static int[] shuffle(int[] a) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = a.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int tmp = a[index];
            a[index] = a[i];
            a[i] = tmp;
        }
        return a;
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    private static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}