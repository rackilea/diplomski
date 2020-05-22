public class ThisClass<U extends SomeClass & SomeInterface<AnotherClass>>
                                   implements AnotherInterface<AnotherClass> {

    private final U obj;

    public ThisClass(U obj) {
        this.obj = obj;
    }

    public U getObject() {
        return obj;
    }
}