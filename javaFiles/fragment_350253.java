public class Test {
    public static void main(String... args) {
        // does not compile
        System.out.println(R.layout.x);
    }
}

class R {
    static final class layout {
        static int x = 42;
    };
    static final int layout = 25;
}