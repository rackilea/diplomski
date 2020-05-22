public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.anotherMethod();
    }

    {
        System.out.println("Instance execution");
    }

    private void anotherMethod() {
        System.out.println("Method execution");
    }
}