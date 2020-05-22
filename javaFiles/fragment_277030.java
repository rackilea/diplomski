when(mock.someMethod(anyString())).thenAnswer(new Answer() {
    public Object answer(InvocationOnMock invocation) {
        Object[] args = invocation.getArguments();
        Object mock = invocation.getMock();
        return "called with arguments: " + args;
    }
});

// Following prints "called with arguments: foo"
System.out.println(mock.someMethod("foo"));