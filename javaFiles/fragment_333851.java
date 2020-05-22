import gnu.trove.TIntIntHashMap;
import gnu.trove.TIntIntProcedure;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Main {
    public static void main(String... args) throws Exception {
        Random random = new Random(1);
        int[] a = new int[100 * 1000];
        int k = 10;
        for (int i = 0; i < a.length; i++)
            a[i] = random.nextInt(100);

        for (int i = 0; i < 5; i++) {
            testSet(a, k);
            testTroveSet(a, k);
            testLoops(a, k);
        }
    }

    private static void testSet(int[] a, int k) {
        Map<Integer, Integer> readNumbers = new HashMap<Integer, Integer>();
        for (int num : a) {
            Integer freq = readNumbers.get(num);
            readNumbers.put(num, freq == null ? 1 : freq + 1);
        }

        long start = System.nanoTime();
        int count = 0;
        for (Integer aNumber : readNumbers.keySet()) {
            if (readNumbers.containsKey(aNumber + k)) {
                count += (readNumbers.get(aNumber) * readNumbers.get(aNumber + k));
            }
        }
        long time = System.nanoTime() - start;
        System.out.printf("Set: %,d took %.3f ms%n", count, time / 1e6);
    }

    private static void testTroveSet(int[] a, final int k) {
        final TIntIntHashMap readNumbers = new TIntIntHashMap();
        for (int num : a)
            readNumbers.adjustOrPutValue(num, 1,1);

        long start = System.nanoTime();
        final int[] count = { 0 };
        readNumbers.forEachEntry(new TIntIntProcedure() {
            @Override
            public boolean execute(int key, int keyCount) {
                count[0] += readNumbers.get(key + k) * keyCount;
                return true;
            }
        });
        long time = System.nanoTime() - start;
        System.out.printf("Trove Set: %,d took %.3f ms%n", count[0], time / 1e6);
    }

    private static void testLoops(int[] a, int k) {
        long start = System.nanoTime();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = a[j] - a[i];
                if (diff == k || -diff == k) {
                    count++;
                }
            }
        }
        long time = System.nanoTime() - start;
        System.out.printf("Loops: %,d took %.1f ms%n", count, time / 1e6);
    }

    private static long free() {
        return Runtime.getRuntime().freeMemory();
    }
}