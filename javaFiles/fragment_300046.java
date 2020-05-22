@MyQualifier
public class Parent extends Child {

    @Inject
    protected void setFoo(@MyQualifier SimpleFoo foo) {
        this.foo = foo;
    }
}