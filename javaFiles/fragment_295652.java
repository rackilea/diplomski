public class Foo {

    private static class Scanner {

        public Scanner(InputStream in) {

        }
    }

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println(in.getClass());

        Scanner in2 = new Scanner(System.in);
        System.out.println(in2.getClass());
    }
}