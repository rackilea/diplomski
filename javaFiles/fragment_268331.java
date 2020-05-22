public class Test1 {
    private final String name;

    public Test1() {
        name = "abc";
        fs = n -> {
            System.out.println(this.name);// Line 1
            return n;

        };
    }

    @SuppressWarnings("rawtypes")
    private final Function fs;

    public static void main(String[] args) {
        new Test1();
    }
}