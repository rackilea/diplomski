public class VisitorExample {
    public static void main(String[] args) {
        AConverterVisitor converterVisitor = new AConverterVisitor();
        A a = new A();
        B b = new B();
        AOther aother = a.accept(converterVisitor);
        System.out.println("Got AOther!");

        try {
            b.accept(converterVisitor); 
        } catch (IllegalArgumentException iae) {
            System.out.println("Calling accept on b with a AConverterVisitor will result in a exception");
        }

    }
}