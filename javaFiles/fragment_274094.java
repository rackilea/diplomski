class Foo {

    private static String before = "before";

    static {
        before = "in init";
        after = "in init";
        leftDefault = "in init";
    }

    private static String after = "after";
    private static String leftDefault;

    static void dump() {
        System.out.println("before = " + before);
        System.out.println("after = " + after);
        System.out.println("leftDefault = " + leftDefault);
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        Foo.dump();
    }
}