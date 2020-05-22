public class AClass {

    private AClass aClass;

    public AClass() {
        this.aClass = new AClass();
        this.aClass.printHello();
    }

    private void printHello() {
        System.out.println("Hello");
    }

    public static void main(final String[] args) {
        new AClass();
    }
}