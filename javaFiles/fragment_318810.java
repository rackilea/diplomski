@RunWith(MockitoJUnitRunner.class)
public class TestSomeClass {
    @Tested private SomeClass classBeingTested;
    @Injectable SomeInnerClass innerClass;
    @Mock
    InputClass input; // doesn't matter if I use @mocked here

    @Test
    public void shouldTestSomething() {
        new NonStrictExpectations() {{
            // some expectations with innerClass...
        }};     
        Mockito.when(input).getSomeLong().thenReturn("11").thenReturn("11");//This will return 11 in place of input.getSomeLong()for 2 times
        classBeingTested.myMethod(input); // In this case yoou will not get an error from Long.parsLong() 

        // ... 
    }
}