@Test
public void testMethod1() throws Exception {
    SomeClass someClass = new SomeClass();
    SomeClass spy = Mockito.spy(someClass);
    Mockito.when(spy.getData()).thenReturn(Arrays.asList("blaat", "blabla"));
    spy.method1();
}