public class Foo {
    private final String field1;
    private final int field2;

    @Builder
    private Foo(String field1, int field2) throws JAXBException
    {
        this.field1 = field1;
        this.field2 = field2;
        throw new JAXBException("a");
    }
}