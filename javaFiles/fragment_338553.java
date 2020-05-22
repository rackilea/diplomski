public class FooTest {

    static class Foo {

        public void someMethod() {
            System.out.println("someMethod called");
            System.out.println("calling method to be verified...");
            methodToBeVerified();
        }

        public void methodToBeVerified() {
            System.out.println("methodToBeVerified called");
        }
    }

    @Test
    public void someTest() throws Exception {
        Foo foo = spy(new Foo());
        doNothing().when(foo).methodToBeVerified();
        foo.someMethod();
        verify(foo).methodToBeVerified();
    }

}