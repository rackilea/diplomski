import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;

/**
 * @author Saint Hill <http://stackoverflow.com/users/1584255/saint-hill>
 */
public final class TestStrings {

    // we will not test strings longer than 512KM
    final int MAX_STRING_SIZE = 1024 * 256;

    // for each string size, we will do all the tests
    // this many times
    final int TRIES_PER_STRING_SIZE = 1000;

    public static void main(String[] args) throws Exception {
        new TestStrings().run();
    }

    void run() throws Exception {

        // double the length of the data until it reaches MAX chars long
        // 0,1,2,4,8,16,32,64,128,256 ... 
        final List<Integer> sizes = new ArrayList<>();
        for (int n = 0; n <= MAX_STRING_SIZE; n = (n == 0 ? 1 : n * 2)) {
            sizes.add(n);
        }

        // CREATE RANDOM (FOR SHUFFLING ORDER OF TESTS)
        final Random random = new Random();

        System.out.println("Rate in nanoseconds per character inspected.");
        System.out.printf("==== FORWARDS (tries per size: %s) ==== \n", TRIES_PER_STRING_SIZE);

        printHeadings(TRIES_PER_STRING_SIZE, random);

        for (int size : sizes) {
            reportResults(size, test(size, TRIES_PER_STRING_SIZE, random));
        }

        // reverse order or string sizes
        Collections.reverse(sizes);

        System.out.println("");
        System.out.println("Rate in nanoseconds per character inspected.");
        System.out.printf("==== BACKWARDS (tries per size: %s) ==== \n", TRIES_PER_STRING_SIZE);

        printHeadings(TRIES_PER_STRING_SIZE, random);

        for (int size : sizes) {
            reportResults(size, test(size, TRIES_PER_STRING_SIZE, random));

        }
    }

    ///
    ///
    ///  METHODS OF CHECKING THE CONTENTS
    ///  OF A STRING. ALWAYS CHECKING FOR
    ///  WHITESPACE (CHAR <=' ')
    ///  
    ///
    // CHECK THE STRING CONTENTS
    int charAtMethod1(final String data) {
        final int len = data.length();
        for (int i = 0; i < len; i++) {
            if (data.charAt(i) <= ' ') {
                doThrow();
            }
        }
        return len;
    }

    // SAME AS ABOVE BUT USE String.length()
    // instead of making a new final local int 
    int charAtMethod2(final String data) {
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) <= ' ') {
                doThrow();
            }
        }
        return data.length();
    }

    // USE new Java-8 String's IntStream
    // pass it a PREDICATE to do the checking
    int streamMethod(final String data, final IntPredicate predicate) {
        if (data.chars().anyMatch(predicate)) {
            doThrow();
        }
        return data.length();
    }

    // OH LA LA - GO PARALLEL!!!
    int streamParallelMethod(final String data, IntPredicate predicate) {
        if (data.chars().parallel().anyMatch(predicate)) {
            doThrow();
        }
        return data.length();
    }

    // Re-fill a resuable char[] with the contents
    // of the String's char[]
    int reuseBuffMethod(final char[] reusable, final String data) {
        final int len = data.length();
        data.getChars(0, len, reusable, 0);
        for (int i = 0; i < len; i++) {
            if (reusable[i] <= ' ') {
                doThrow();
            }
        }
        return len;
    }

    // Obtain a new copy of char[] from String
    int newMethod1(final String data) {
        final int len = data.length();
        final char[] copy = data.toCharArray();
        for (int i = 0; i < len; i++) {
            if (copy[i] <= ' ') {
                doThrow();
            }
        }
        return len;
    }

    // Obtain a new copy of char[] from String
    // but use FOR-EACH
    int newMethod2(final String data) {
        for (final char c : data.toCharArray()) {
            if (c <= ' ') {
                doThrow();
            }
        }
        return data.length();
    }

    // FANCY!
    // OBTAIN FIELD FOR ACCESS TO THE STRING'S
    // INTERNAL CHAR[]
    int fieldMethod1(final Field field, final String data) {
        try {
            final char[] chars = (char[]) field.get(data);
            final int len = chars.length;
            for (int i = 0; i < len; i++) {
                if (chars[i] <= ' ') {
                    doThrow();
                }
            }
            return len;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    // same as above but use FOR-EACH
    int fieldMethod2(final Field field, final String data) {
        final char[] chars;
        try {
            chars = (char[]) field.get(data);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        for (final char c : chars) {
            if (c <= ' ') {
                doThrow();
            }
        }
        return chars.length;
    }

    /**
     *
     * Make a list of tests. We will shuffle a copy of this list repeatedly
     * while we repeat this test.
     *
     * @param data
     * @return
     */
    List<Jobber> makeTests(String data) throws Exception {
        // make a list of tests
        final List<Jobber> tests = new ArrayList<Jobber>();

        tests.add(new Jobber("charAt1") {
            int check() {
                return charAtMethod1(data);
            }
        });

        tests.add(new Jobber("charAt2") {
            int check() {
                return charAtMethod2(data);
            }
        });

        tests.add(new Jobber("stream") {
            final IntPredicate predicate = new IntPredicate() {
                public boolean test(int value) {
                    return value <= ' ';
                }
            };

            int check() {
                return streamMethod(data, predicate);
            }
        });

        tests.add(new Jobber("streamPar") {
            final IntPredicate predicate = new IntPredicate() {
                public boolean test(int value) {
                    return value <= ' ';
                }
            };

            int check() {
                return streamParallelMethod(data, predicate);
            }
        });

        // Reusable char[] method
        tests.add(new Jobber("reuse") {
            final char[] cbuff = new char[MAX_STRING_SIZE];

            int check() {
                return reuseBuffMethod(cbuff, data);
            }
        });

        // New char[] from String
        tests.add(new Jobber("new1") {
            int check() {
                return newMethod1(data);
            }
        });

        // New char[] from String
        tests.add(new Jobber("new2") {
            int check() {
                return newMethod2(data);
            }
        });

        // Use reflection for field access
        tests.add(new Jobber("field1") {
            final Field field;

            {
                field = String.class.getDeclaredField("value");
                field.setAccessible(true);
            }

            int check() {
                return fieldMethod1(field, data);
            }
        });

        // Use reflection for field access
        tests.add(new Jobber("field2") {
            final Field field;

            {
                field = String.class.getDeclaredField("value");
                field.setAccessible(true);
            }

            int check() {
                return fieldMethod2(field, data);
            }
        });

        return tests;
    }

    /**
     * We use this class to keep track of test results
     */
    abstract class Jobber {

        final String name;
        long nanos;
        long chars;
        long runs;

        Jobber(String name) {
            this.name = name;
        }

        abstract int check();

        final double nanosPerChar() {
            double charsPerRun = chars / runs;
            long nanosPerRun = nanos / runs;
            return charsPerRun == 0 ? nanosPerRun : nanosPerRun / charsPerRun;
        }

        final void run() {
            runs++;
            long time = System.nanoTime();
            chars += check();
            nanos += System.nanoTime() - time;
        }
    }

    // MAKE A TEST STRING OF RANDOM CHARACTERS A-Z
    private String makeTestString(int testSize, char start, char end) {
        Random r = new Random();
        char[] data = new char[testSize];
        for (int i = 0; i < data.length; i++) {
            data[i] = (char) (start + r.nextInt(end));
        }
        return new String(data);
    }

    // WE DO THIS IF WE FIND AN ILLEGAL CHARACTER IN THE STRING
    public void doThrow() {
        throw new RuntimeException("Bzzzt -- Illegal Character!!");
    }

    /**
     * 1. get random string of correct length 2. get tests (List<Jobber>) 3.
     * perform tests repeatedly, shuffling each time
     */
    List<Jobber> test(int size, int tries, Random random) throws Exception {
        String data = makeTestString(size, 'A', 'Z');
        List<Jobber> tests = makeTests(data);
        List<Jobber> copy = new ArrayList<>(tests);
        while (tries-- > 0) {
            Collections.shuffle(copy, random);
            for (Jobber ti : copy) {
                ti.run();
            }
        }
        // check to make sure all char counts the same
        long runs = tests.get(0).runs;
        long count = tests.get(0).chars;
        for (Jobber ti : tests) {
            if (ti.runs != runs && ti.chars != count) {
                throw new Exception("Char counts should match if all correct algorithms");
            }
        }
        return tests;
    }

    private void printHeadings(final int TRIES_PER_STRING_SIZE, final Random random) throws Exception {
        System.out.print("  Size");
        for (Jobber ti : test(0, TRIES_PER_STRING_SIZE, random)) {
            System.out.printf("%9s", ti.name);
        }
        System.out.println("");
    }

    private void reportResults(int size, List<Jobber> tests) {
        System.out.printf("%6d", size);
        for (Jobber ti : tests) {
            System.out.printf("%,9.2f", ti.nanosPerChar());
        }
        System.out.println("");
    }
}