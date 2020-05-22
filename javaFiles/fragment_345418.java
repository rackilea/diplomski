class Test {

    static int x;
    static String y;

    public static void main(String[] args) {
        System.out.println(x);
        System.out.println(y);

        int lx;
        String ly;
        System.out.println(lx); // Compile-time error
        System.out.println(ly); // Compile-time error
    }
}