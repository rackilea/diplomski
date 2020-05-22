public class SimpleTest {

    // Yes, you can call a method as a field initialization!
    private int myInt = myMethod();

    // The method performs a calculation end returns a value.
    private int myMethod() {
        return (int)Math.sqrt(9.0);
    }

    // Getter for the field
    public int getMyInt() {
        return myInt;
    }

    public static void main(String[] args) {            
        SimpleTest test = new SimpleTest();
        System.out.println( test.getMyInt());
    }

}