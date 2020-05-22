doAnswer(new Answer() {
    Object answer(InvocationOnMock invocation) {
        Object[] args = invocation.getArguments();
        ((MyClass)args[0]).myClassSetMyField(NEW_VALUE);
        return null; // void method, so return null
    }
}).when(mock).someMethod();