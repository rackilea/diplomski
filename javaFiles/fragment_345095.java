public class Test {
    public void doStuff() {
        System.out.println("Test");
    }

    public static void main(String[] args) {
        Test testObj = new Test() {
            public void doStuff() {
                System.out.println("Inside anonymous class doStuff");
                doOtherStuff(); // calling new method doOtherStuff() and it works
            }

            public void doOtherStuff() {
                System.out.println("Inside anonymous class doOtherStuff");
            }
        };
        testObj.doStuff();

        /*Below code give compilation error: The method doOtherStuff() is undefined for the type Test*/
        // testObj.doOtherStuff();
    }
}