public static void main(String[] args) throws Exception {
    final AtomicInteger a = new AtomicInteger(0);
    System.out.printf("a:%s%n",a);
    final AtomicInteger b = a;
    System.out.printf("a:%s.b:%s%n", a, b);
    a.set(10);
    System.out.printf("a:%s.b:%s%n", a, b);
    b.set(5);
    System.out.printf("a:%s.b:%s%n", a, b);
}