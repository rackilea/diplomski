public class MyClassTest
{
    @Test
    public void doSomething() {
        A a = mock(A.class);
        // set expectations for A ...
        AFactory aFactory = mock(AFactory.class);
        when(aFactory.create(100, 101)).thenReturn(a);
        MyClass fixture = new MyClass(aFactory);
        fixture.doSomething();
        // make assertions ...
    }
}