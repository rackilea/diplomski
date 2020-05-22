public class MyCustomTest implements CustomTest {
    @Override
    public void test(Object implicitObject) {
        implicitObject.doSpecificThing();
    }
}