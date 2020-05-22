public static void main(String[] args) {
    MutableInteger sharedObject = new MutableInteger();
    MutableIntegerTester tester1 = new MutableIntegerTester(10, sharedObject);
    MutableIntegerTester tester2 = new MutableIntegerTester(99, sharedObject);
    new Thread(tester1).start();
    new Thread(tester2).start();
}