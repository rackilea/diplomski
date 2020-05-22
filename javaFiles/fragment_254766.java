public void test() {
    String a = "0123456789";
    StringBuilder b = new StringBuilder(a);
    System.out.println("a=" + a + " b=" + b);
    a = a.substring(0, 2) + a.substring(5);
    b.delete(2, 5);
    System.out.println("a=" + a + " b=" + b);
}