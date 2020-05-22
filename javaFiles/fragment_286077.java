public class ExampleUnitTest {
    @Test
    public void testSpyObject() throws Exception {
        SpyTestObject spyTestObject = new SpyTestObject();
        SpyTestObject spy = Mockito.spy(spyTestObject);

        Mockito.doNothing().when(spy).methodB();

        spy.methodA();
        Mockito.verify(spy).methodB();
    }

    public class SpyTestObject {

        public void methodA() {
            methodB();
        }
        public void methodB() {
            throw new RuntimeException();
        }
    }