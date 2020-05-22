public void testUnstubbedException() {
    // Create a mock with all methods throwing a RuntimeException by default
    SomeClass someClass = mock( SomeClass .class, new RuntimeExceptionAnswer() );

    doReturn(1).when(someClass).getId(); // Must use doReturn

    int id = someClass.getId(); // Will return 1

    someClass.unstubbedMethod(); // Will throw RuntimeException
}

public static class RuntimeExceptionAnswer implements Answer<Object> {

    public Object answer( InvocationOnMock invocation ) throws Throwable {
        throw new RuntimeException ( invocation.getMethod().getName() + " is not stubbed" );
    }

}