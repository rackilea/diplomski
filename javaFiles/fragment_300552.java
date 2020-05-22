public static void main(String[] args) {
    String a = "11111";
    String b = "10001";
    long la = Long.parseLong(a, 2);
    long lb = Long.parseLong(b, 2);
    long lc = la & lb;
    String c = Long.toBinaryString(lc);

    System.out.println(c); // prints 10001
}