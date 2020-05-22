class AClassTest {

    @Test
    public void testAFunction() {
         Aclass testObject = new TestableAclass();
         boolean value = testObject.AFunction();
         // now you can assert on the return value
    }

    class TestableAclass extends Aclass {
        @Override
        protected String doBfunction() {
             // Here you can do whatever you want to simulate this method
             return "some string";  
        }
    }
}