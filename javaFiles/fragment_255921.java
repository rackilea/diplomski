class Foo {
    public void foo() {}
    public void bar() {}
}

class Bar {
    public void foo() {}
}

@Test
public void testFoo() {

    Foo mock = mock(Foo.class);
    Bar mock2 = mock(Bar.class);
    mock.foo(); //1st
    mock.bar(); //2nd
    mock2.foo(); //3rd

    InOrder inOrder = inOrder(mock, mock2);

    inOrder.verify(mock).foo(); //1st
    inOrder.verify(mock2).foo(); //3rd (last method)

    //passes because there are no more interactions after last method:
    inOrder.verifyNoMoreInteractions();
}