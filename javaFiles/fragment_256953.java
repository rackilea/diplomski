public class Test {

    {
        System.out.println("Initializer block");
    }

    Test() {
        System.out.println("Constructor 1");
    }

    Test(int i) {
        System.out.println("Constructor 2");
    }

    public static void main(String[] args) {
        new Test();
        System.out.println("---");
        new Test(1);
    }
}