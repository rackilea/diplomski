public class Outer {

    public void test(int i) {
        class Inner {
            private int x = i; // i may be different on each call of test

            public void display() {
                System.out.println("Inner x is: " + x);
            }
        }
        Inner inner = new Inner();
        inner.display();
    }

    public void test2() {
        test(1); // prints 1
        test(2); // prints 2

        //now imagine this is valid
        Inner inner2 = new Inner();
        inner2.display();// what's the value of x??
    }
}