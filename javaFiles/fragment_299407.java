@RunWith(PowerMockRunner.class)
@PrepareForTest(Foo.class)
public class FooMockAllInstanceTest {

    @Test
    public void testMockInstanceofObjectCreation() throws Exception {
        Bar mockBar = PowerMockito.mock(Bar.class);
        when(mockBar.sayHello()).thenReturn("Hi John!");
        PowerMockito.whenNew(Bar.class)
                .withNoArguments()
                .thenReturn(mockBar);

        Foo myFooOne = new Foo();
        assertEquals(mockBar,  myFooOne.doSomething("Jane"));

        Foo myFooTwo = new Foo();
        assertEquals(mockBar,  myFooTwo.doSomething("Sarah"));

        Baz bazOne = new Baz();
        assertEquals(mockBar, bazOne.doSomething("Sam"));

        Baz bazTwo = new Baz();
        assertEquals(mockBar, bazTwo.doSomething("Nina"));
    }
}