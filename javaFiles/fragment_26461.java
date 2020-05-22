class Test {
    public static void main(String[] args) {
        byte a = (byte)128;
        int x1 = a << 8;
        int x2 = (a & 0xff) << 8;
        System.out.println(x1);
        System.out.println(x2);
    }
}