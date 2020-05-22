public class A {
    volatile String aString;

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Thread t = new Thread(a.new B());
        t.start();
        t.join(); // wait for t to finish
        System.out.println(a.aString); // prints "foo"
    }

    class B implements Runnable {
        public void run() {
            aString = "foo";
        }
    }
}