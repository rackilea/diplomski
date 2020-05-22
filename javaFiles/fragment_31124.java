class ApplicationTests {

    @Mock
    MyConfig myConfig;

    @Test
    public void testMethodA() {

        ...
        MyUtility spy = Mockito.spy(new MyUtility(myConfig));
        Mockito.when(spy.methodB()).thenReturn("someValue");

        spy.methodA();
        ...
    }
}