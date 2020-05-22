private ClassUnderTest classUnderTest;

@Before
public void setUp() {
    classUnderTest= new ClassUnderTest();
    classUnderTest = Mockito.spy(classUnderTest);
}

@Test
public void test() {
    SomeObject someObject = Mockito.mock(SomeObject.class);
    when(classUnderTest.getSomeObject()).thenReturn(someObject);
    classUnderTest.methodUnderTest();
    verify(someObject).someOtherMethod();
}

@Test
public void testNull() {
    when(classUnderTest.getSomeObject()).thenReturn(null);
    classUnderTest.methodUnderTest();
    verify(something);
}