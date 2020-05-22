@Test
public void testHasEntryCast() {
    Service mockService = mock(Service.class);
    Foo foo = new Foo(mockService);

    foo.bar();

    verify(mockService).activate((Map<String, ?>)  argThat(hasEntry("paramName", "paramValue")));
}