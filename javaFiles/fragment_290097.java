public class StringReplaceTest {

    public static void main(String[] args) {
        int iterations = 1000000;

        String[] exclude = { "one", "two", "three" };
        String input = "if we add one and two we get three";

        StringRemove replaceAll = new StringReplaceAll();
        StringRemove replace = new StringReplace();
        StringRemove stringUtilsRemove = new StringUtilsRemove();

        // check if the replacement is implemented correctly
        assertStringRemove(replaceAll);
        assertStringRemove(replace);
        assertStringRemove(stringUtilsRemove);

        profileStringRemove(replaceAll, input, exclude, iterations);
        profileStringRemove(replace, input, exclude, iterations);
        profileStringRemove(stringUtilsRemove, input, exclude, iterations);

    }

    private static void assertStringRemove(StringRemove stringRemove) {
        String[] exclude = { "one", "two", "three" };
        String input = "if we add one and two we get three";
        String replaced = stringRemove.remove(input, exclude);

        String expected = "if we add  and  we get ";
        if (!expected.equals(replaced)) {
            throw new IllegalStateException(
                    "String was not replaced correctly. Excpected <" + expected
                            + "> but was <" + replaced + ">");
        }
    }

    private static void profileStringRemove(StringRemove stringRemove,
            String input, String[] subStringsToRemove, int iterations) {
        long start = System.currentTimeMillis();
        int testCount = iterations;
        while (iterations-- > 0) {
            stringRemove.remove(input, subStringsToRemove);
        }
        long end = System.currentTimeMillis();
        printSummery(stringRemove.getClass().getSimpleName(), testCount, start,
                end);
    }

    private static void printSummery(String action, int iterations, long start,
            long end) {
        System.out.println(action + " took: " + (end - start) + " ms for "
                + iterations + " iterations");
    }