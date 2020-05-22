public class Test {
    public static void main(String[] args) {
        int x;
        if (args.length > 0) {
            x = 1;
        } else {
            x = 2;
        }
    }

    public static void main2(String[] args) {
        int x = (args.length > 0) ? 1 : 2;
    }
}