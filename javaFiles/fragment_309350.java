public static Object identity(Object x) {
    return x;
}
public static void main(String args[]) {
    String a = (String)identity("foo");
    System.out.println(a.getClass().getName());

    Object b = identity("foo");
    System.out.println(b.getClass().getName());
}