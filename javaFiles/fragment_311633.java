public class PerfTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b");
        long time1 = System.currentTimeMillis();
        for (long i = 0; i < 1E10; i++) {
            func1("a", "b");
        }
        long time2 = System.currentTimeMillis();
        for (long i = 0; i < 1E10; i++) {
            func2(list);
        }
        System.out.println((time2 - time1) + "/" + (System.currentTimeMillis() - time2));
    }

    private static void func1(String s1, String s2) { }
    private static void func2(List<String> sl) { }
}