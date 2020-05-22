class Foo {
    public void foo() {}
    public void bar() {}
    public void baz() {}
}

@Test
public void testFoo() {

    Foo mock = mock(Foo.class);
    mock.foo(); //1st
    mock.bar(); //2nd
    mock.baz(); //3rd

    InOrder inOrder = inOrder(mock);

    inOrder.verify(mock).foo(); //1st
    inOrder.verify(mock).baz(); //3rd (last method)

    //passes because there are no more interactions after last method:
    inOrder.verifyNoMoreInteractions();

}