import java.security.SecureRandom;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class HowLong {

    public static final int MAX_TO_GENERATE = 10;

    public static final int TOTAL_RUNS = 1000000;
    public static final int TP50 = (int)(TOTAL_RUNS * 0.50);
    public static final int TP90 = (int)(TOTAL_RUNS * 0.90);
    public static final int TP99 = (int)(TOTAL_RUNS * 0.99);
    public static final int TP99_9 = (int)(TOTAL_RUNS * 0.999);
    public static final int TP100 = (int)(TOTAL_RUNS * 1);

    public static final String[] TP_NAMES = {"TP50", "TP90", "TP99", "TP99.9", "TP100"};
    public static final int[] TPS = { TP50, TP90, TP99, TP99_9, TP100 };

    public interface RandomSource {
        int next();
    }

    public static class MathRandomSource implements RandomSource {
        private final Random rand;

        public MathRandomSource() {
            rand = new Random();
        }

        public int next() {
            return rand.nextInt(MAX_TO_GENERATE);
        }
    }

    public static class SecureRandomSource implements RandomSource {
        private final SecureRandom rand;

        public SecureRandomSource() {
            rand = new SecureRandom();
        }

        public int next() {
            return rand.nextInt(MAX_TO_GENERATE);
        }
    }

    public static int waitForTen() {

        final boolean[] found = new boolean[MAX_TO_GENERATE];
        int remaining = found.length;

        final RandomSource source = new SecureRandomSource();
        int iterations = 0;
        while (remaining > 0) {
            int next = source.next();
            if (!found[next]) {
                found[next] = true;
                remaining -= 1;
            }
            iterations += 1;
        }

        return iterations;
    }

    public static void main(String[] args) {
        System.out.println("Attempting to generate all numbers below: " + MAX_TO_GENERATE);
        System.out.println("Performing n iterations: " + TOTAL_RUNS);

        TreeMap<Integer, Integer> results = new TreeMap<Integer, Integer>();
        for (int i = 0; i < TOTAL_RUNS; i += 1) {
            Integer iterations = waitForTen();
            Integer currentCount = results.get(iterations);
            if (currentCount == null) {
                results.put(iterations, 1);
            } else {
                results.put(iterations, currentCount + 1);
            }
        }
        int currTP = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: results.entrySet()) {
            count += entry.getValue();
            while (currTP < TPS.length && count >= TPS[currTP]) {
                System.out.println(TP_NAMES[currTP] + ": " + entry.getKey());
                currTP += 1;
            }
        }
    }

}