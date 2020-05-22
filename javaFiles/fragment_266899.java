public class VisitorExample {
    public static void main(String[] args) {
        ConverterVisitor converterVisitor = new ConverterVisitor();
        A a = new A();
        B b = new B();
        a.accept(converterVisitor);
        AbsOther aother = converterVisitor.getOther();
        b.accept(converterVisitor);
        AbsOther bother = converterVisitor.getOther();
    }
}