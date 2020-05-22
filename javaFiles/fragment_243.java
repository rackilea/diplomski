public class Outer {
    String hello = "hello";

    public void myMethod() {

        class Inner {
            public void myInnerMethod() {
                Outer.this.printHello(hello);    // !!! change here     
            }
        }

        [...really slow routine...]

        (new Inner()).myInnerMethod();
    }

    void printHello(String hello){/* */}   // !! add this
}