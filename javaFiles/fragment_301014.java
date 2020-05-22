public class Test1 {
    public static void main(String[] args) {
        new Test1().m(1, 2);
    }
    int m(int... i) {
        System.out.println("int");
        return 0;
    }
    long m(long... i) {
        System.out.println("long");
        return 0;
    }
}