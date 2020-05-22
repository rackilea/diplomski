public class FooTest {
     @Mock
     private Foo foo;

     ...
     @Before
     public void setUp() {
        MockitoAnnotations.initMocks(this);
     }

     @Test
     public void testSomething() {
        Bar object = new Bar();
        when(foo.doSomething(any(Any.class))).thenReturn(object);
        ...
     }
}