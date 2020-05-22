public class Test {

    private String s1 = "Hi";

    public static void main(String [] args) {

        new Test().test();
        System.exit(0);
    }

    public void test() {
        String s2 ="Hi";
        String s3;

        System.out.println("[statics]          s2 == s1? " + (s2 == s1));
        s3 = "H" + part2();
        System.out.println("[before interning] s3 == s1? " + (s3 == s1));
        s3 = s3.intern();
        System.out.println("[after interning]  s3 == s1? " + (s3 == s1));
        System.exit(0);
    }

    protected String part2() {
        return "i";
    }
}