private MyInterface impl = new MyInterfaceImpl(){
    public final MyInterface mock = EasyMock.createMock(MyInterface.class);
    @override //only the method you need to mock
    public SomeType second(){
        return mock.second();        
    }
}

@Test
public void testFirst() {
    // modify behaviour of .second()
    EasyMock.expect(impl.mock.second()).andReturn("What I want").anyTimes();
    impl.first();
    assertSomething(...);

    // modify behaviour of .second()
    EasyMock.expect(impl.mock.second()).andReturn("Now I want something else").anyTimes();
    impl.first();
    assertSomethingElse(...);
}