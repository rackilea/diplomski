import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LZ78 {
    /**
     * Uses the LZ78 compression algorithm to approximate the Kolmogorov
     * complexity of a String
     * 
     * @param s
     * @return the approximate Kolmogorov complexity
     */
    public static double kComplexity(String s) {
        Set<String> dictionary = new HashSet<String>();
        StringBuilder w = new StringBuilder();
        double comp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictionary.contains(w.toString() + c)) {
                w.append(c);
            } else {
                comp++;
                dictionary.add(w.toString() + c);
                w = new StringBuilder();
            }
        }
        if (w.length() != 0) {
            comp++;
        }
        return comp;
    }

    private static boolean equal(Object o1, Object o2) {
        return o1 == o2 || (o1 != null && o1.equals(o2));
    }

    public static final class FList<T> {
        public final FList<T> head;
        public final T tail;
        private final int hashCodeValue;

        public FList(FList<T> head, T tail) {
            this.head = head;
            this.tail = tail;
            int v = head != null ? head.hashCodeValue : 0;
            hashCodeValue = v * 31 + (tail != null ? tail.hashCode() : 0);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof FList<?>) {
                FList<?> that = (FList<?>) obj;
                return equal(this.head, that.head)
                        && equal(this.tail, that.tail);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return hashCodeValue;
        }

        @Override
        public String toString() {
            return head + ", " + tail;
        }
    }

    public static final class FListChar {
        public final FListChar head;
        public final char tail;
        private final int hashCodeValue;

        public FListChar(FListChar head, char tail) {
            this.head = head;
            this.tail = tail;
            int v = head != null ? head.hashCodeValue : 0;
            hashCodeValue = v * 31 + tail;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof FListChar) {
                FListChar that = (FListChar) obj;
                return equal(this.head, that.head) && this.tail == that.tail;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return hashCodeValue;
        }

        @Override
        public String toString() {
            return head + ", " + tail;
        }
    }

    public static double kComplexity2(String s) {
        Map<FList<Character>, FList<Character>> dictionary = 
            new HashMap<FList<Character>, FList<Character>>();
        FList<Character> w = null;
        double comp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            FList<Character> w1 = new FList<Character>(w, c);
            FList<Character> ex = dictionary.get(w1);
            if (ex != null) {
                w = ex;
            } else {
                comp++;
                dictionary.put(w1, w1);
                w = null;
            }
        }
        if (w != null) {
            comp++;
        }
        return comp;
    }

    public static double kComplexity3(String s) {
        Map<FListChar, FListChar> dictionary = 
            new HashMap<FListChar, FListChar>(1024);
        FListChar w = null;
        double comp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            FListChar w1 = new FListChar(w, c);
            FListChar ex = dictionary.get(w1);
            if (ex != null) {
                w = ex;
            } else {
                comp++;
                dictionary.put(w1, w1);
                w = null;
            }
        }
        if (w != null) {
            comp++;
        }
        return comp;
    }

    public static void main(String[] args) throws Exception {
        File f = new File("methods.txt");
        byte[] data = new byte[(int) f.length()];
        FileInputStream fin = new FileInputStream(f);
        int len = fin.read(data);
        fin.close();
        final String test = new String(data, 0, len);

        final int n = 100;
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.submit(new Runnable() {
            @Override
            public void run() {
                long t = System.nanoTime();
                double value = 0;
                for (int i = 0; i < n; i++) {
                    value += kComplexity(test);
                }
                System.out.printf("kComplexity: %.3f; Time: %d ms%n",
                        value / n, (System.nanoTime() - t) / 1000000);
            }
        });
        exec.submit(new Runnable() {
            @Override
            public void run() {
                long t = System.nanoTime();
                double value = 0;
                for (int i = 0; i < n; i++) {
                    value += kComplexity2(test);
                }
                System.out.printf("kComplexity2: %.3f; Time: %d ms%n", value
                        / n, (System.nanoTime() - t) / 1000000);
            }
        });
        exec.submit(new Runnable() {
            @Override
            public void run() {
                long t = System.nanoTime();
                double value = 0;
                for (int i = 0; i < n; i++) {
                    value += kComplexity3(test);
                }
                System.out.printf("kComplexity3: %.3f; Time: %d ms%n", value
                        / n, (System.nanoTime() - t) / 1000000);
            }
        });
        exec.shutdown();
    }
}