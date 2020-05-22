public class TestObject {
    int x;

    public TestObject() {
        System.out.println("Constructor called");
        x++;
    }

    public static void main(String[] args) {
        TestObject obj = new TestObject();
        System.out.println("x = " + obj.x);  // x = 1

        ConstructorInvoker.invoke(obj);
        System.out.println("x = " + obj.x);  // x = 2
    }
}