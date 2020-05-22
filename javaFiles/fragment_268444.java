public static void main(String[] args) throws InterruptedException {
    MyIntegerBounded m = new MyIntegerBounded(24, 60);
    System.out.println(m.get());   // 24
    m.increment();
    System.out.println(m.get());   // 25
    m.add(40);
    System.out.println(m.get());   //  5
}