public class Test {

    public static void main(String[] args) {
        Test test = new Test();
    }

    {
        System.out.println("Instance execution");
    }

    private void anotherMethod() {
        System.out.println("Method execution");
    }

    static // <==================
    {
        System.out.println("Class initialization"); // ***
        Test test = new Test();
        test.anotherMethod();
    }
}