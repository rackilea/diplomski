public static void main(String[] args) {
    TestVolatile testVolatile = new TestVolatile();
    Thread t1 = new Thread(testVolatile,"Thread-1");
    Thread t2 = new Thread(testVolatile,"Thread-2");
    t1.start();
    t2.start();
}