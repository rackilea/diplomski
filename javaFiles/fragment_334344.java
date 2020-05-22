public class StringContainsNumbers {
    public static void main(String[] args) {
        final String s1 = "1 2 7 8";
        final String s2 = "1 7 8";
        final String s3 = "1 2 8";

        System.out.println(stringContainsNumbers(s1, s2));
        System.out.println(stringContainsNumbers(s1, s3));
    }

    private static boolean stringContainsNumbers(String s1, String s2) {
        return Arrays.asList(s1.split(" ")).containsAll(Arrays.asList(s2.split(" ")));
    }
}