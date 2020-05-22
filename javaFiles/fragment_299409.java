@Test
public void testStubbingMethod() throws Exception {
    Bar mockBar = PowerMockito.mock(Bar.class);
    when(mockBar.sayHello()).thenReturn("Hi John!");

    PowerMockito.stub(PowerMockito.method(Foo.class, "doSomething",
            String.class)).toReturn(mockBar);

    Foo myFooOne = new Foo();
    assertEquals(mockBar, myFooOne.doSomething("Jane"));

    Foo myFooTwo = new Foo();
    assertEquals(mockBar, myFooTwo.doSomething("Sarah"));

    Baz bazOne = new Baz();
    assertEquals(mockBar, bazOne.doSomething("Sam"));

    Baz bazTwo = new Baz();
    assertEquals(mockBar, bazTwo.doSomething("Nina"));
}