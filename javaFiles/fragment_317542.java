public class Test {
    public static void main(String[] args) throws Exception {
        int result = a() + b() * c();
    }

    public static int a() {
        System.out.println("a()");
        return 3;
    }

    public static int b() {
        System.out.println("b()");
        return 4;
    }

    public static int c() {
        System.out.println("c()");
        return 5;
    }
}