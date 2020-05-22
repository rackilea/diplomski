public class Dummy {
    public static boolean testInner(String s) {
        return false;
    }

    public static boolean testOuter() {
        String x = "someValue";
        return testInner(x);
    }
}