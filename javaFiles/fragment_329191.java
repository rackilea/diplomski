@Before
public void setUp() {
    // Since your class is abstract you can do it like this
    // to get an anonymous class you can test that non-abstract
    // method with...
    instance = new IntRelation() { };
}